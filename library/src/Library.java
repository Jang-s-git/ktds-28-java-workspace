import java.io.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Library implements Serializable {

    private List<Book> bookList = new ArrayList<>();
    private List<Member> memberList = new ArrayList<>();

    // 중복 제거를 위한 Distinct 유틸 함수
    public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Set<Object> seen = ConcurrentHashMap.newKeySet();
        return t -> seen.add(keyExtractor.apply(t));
    }

    // 신규 책 입고 (임의의 고유번호 부여)
    public void stockBook(String title, String genre, String publisher, String author,
                          LocalDate publishDate, int printEdition, LocalDate stockDate, int price, String isbn) {
        String managementId;
        do {
            managementId = "LIB-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        } while (findBookById(managementId).isPresent());

        Book book = new Book(title, genre, publisher, author, publishDate, printEdition, stockDate, price, isbn, managementId);
        bookList.add(book);
    }

    public void registerMember(String name, String phone) {
        memberList.add(new Member(name, phone));
    }

    // 출판된 지 햇수로 10년이 지난 책 폐기 처리
    public void discardOldBooks(int currentYear) {
        // 대여 중인 책의 폐기 상태 갱신
        bookList.stream()
                .filter(b -> (currentYear - b.getPublishDate().getYear()) >= 10)
                .forEach(b -> b.setDiscarded(true));

        // 도서 목록에서 제외
        bookList = bookList.stream()
                .filter(b -> (currentYear - b.getPublishDate().getYear()) < 10)
                .collect(Collectors.toList());
    }

    // 반납기간 도래(반납일 2일 전부터) 또는 반납일 지난 회원 조회
    public List<Member> getMembersWithDueOrOverdueBooks(LocalDate currentDate) {
        return memberList.stream()
                // 폐기되지 않은 대여 도서가 1권 이상 있는 회원만 필터링
                .filter(member -> member.getRentedBooks().stream().anyMatch(b -> !b.isDiscarded()))
                // 반납일 2일 전(= 대여 후 5일 경과) 이상 지난 유효 도서를 가진 회원
                .filter(member -> member.getRentedBooks().stream()
                        .filter(b -> !b.isDiscarded())
                        .anyMatch(b -> !currentDate.isBefore(b.getRentalDate().plusDays(5))))
                .collect(Collectors.toList());
    }

    // 인기 도서 / 비인기 도서 조회
    public List<Book> getPopularBooks(int limit) {
        return bookList.stream()
                .sorted(Comparator.comparingInt(Book::getTotalRentalCount).reversed())
                .limit(limit)
                .collect(Collectors.toList());
    }

    public List<Book> getUnpopularBooks(int limit) {
        return bookList.stream()
                .sorted(Comparator.comparingInt(Book::getTotalRentalCount))
                .limit(limit)
                .collect(Collectors.toList());
    }

    // 상습 미반납 회원 조회 (연체 횟수 3회 이상)
    public List<Member> getHabitualOverdueMembers() {
        return memberList.stream()
                .filter(m -> m.getOverdueCount() >= 3)
                .sorted(Comparator.comparingInt(Member::getOverdueCount).reversed())
                .collect(Collectors.toList());
    }

    // 도서 검색 (출판사/저자/장르) - 대여 상태 무관, 동일 책(ISBN) 중복 제거 1권만 출력
    public List<Book> searchBooks(String keyword) {
        return bookList.stream()
                .filter(b -> b.getPublisher().contains(keyword)
                        || b.getAuthor().contains(keyword)
                        || b.getGenre().contains(keyword))
                .filter(distinctByKey(Book::getIsbn))
                .collect(Collectors.toList());
    }

    // 도서 대여
    public boolean rentBook(String managementId, String memberName, LocalDate rentDate) {
        Member member = memberList.stream()
                .filter(m -> m.getName().equals(memberName))
                .findFirst()
                .orElse(null);

        if (member == null || member.isRentalRestricted()) {
            return false; // 회원 없음 또는 연체 3회 이상 제한
        }

        Optional<Book> targetBook = bookList.stream()
                .filter(b -> b.getManagementId().equals(managementId) && !b.isRented())
                .findFirst();

        if (targetBook.isPresent()) {
            Book book = targetBook.get();
            book.rent(memberName, rentDate);
            member.getRentedBooks().add(book);
            return true;
        }
        return false;
    }

    // 도서 반납
    public boolean returnBook(String managementId, String memberName, LocalDate actualReturnDate) {
        Member member = memberList.stream()
                .filter(m -> m.getName().equals(memberName))
                .findFirst()
                .orElse(null);

        if (member == null) return false;

        Optional<Book> rentedBookOpt = member.getRentedBooks().stream()
                .filter(b -> b.getManagementId().equals(managementId))
                .findFirst();

        if (!rentedBookOpt.isPresent()) return false;

        Book book = rentedBookOpt.get();

        // 폐기 처리된 도서가 아닐 경우 연체 및 벌금 계산
        if (!book.isDiscarded()) {
            LocalDate dueDate = book.getReturnDate();
            if (actualReturnDate.isAfter(dueDate)) {
                long overdueDays = ChronoUnit.DAYS.between(dueDate, actualReturnDate);
                member.increaseOverdueCount();
                member.addFine((int) overdueDays * 500); // 1일당 500원 누적
            }
            book.returnBook();
        }

        member.getRentedBooks().remove(book);
        return true;
    }

    private Optional<Book> findBookById(String managementId) {
        return bookList.stream().filter(b -> b.getManagementId().equals(managementId)).findFirst();
    }

    // 파일 저장
    public void saveData(String filePath) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(this);
        }
    }

    // 파일 불러오기
    public static Library loadData(String filePath) throws IOException, ClassNotFoundException {
        File file = new File(filePath);
        if (!file.exists()) return new Library();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            return (Library) ois.readObject();
        }
    }

    public List<Book> getBookList() { return bookList; }
    public List<Member> getMemberList() { return memberList; }
}