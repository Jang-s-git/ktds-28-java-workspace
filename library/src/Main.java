import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final String DATA_FILE = "library_data.ser";
    private static Library library;
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // 프로그램 시작 시 파일에서 데이터 로드
        try {
            library = Library.loadData(DATA_FILE);
            System.out.println("기존 데이터를 불러왔습니다.");
        } catch (Exception e) {
            library = new Library();
            System.out.println("신규 데이터베이스로 시작합니다.");
        }

        while (true) {
            System.out.println("\n========== 도서관 관리 시스템 ==========");
            System.out.println("1. 신규 회원 등록");
            System.out.println("2. 신규 도서 입고");
            System.out.println("3. 도서 검색 (출판사/저자/장르)");
            System.out.println("4. 도서 대여");
            System.out.println("5. 도서 반납");
            System.out.println("6. 반납 예정 및 연체 회원 조회");
            System.out.println("7. 인기 / 비인기 도서 조회");
            System.out.println("8. 상습 미반납 회원 조회");
            System.out.println("9. 10년 경과 도서 일괄 폐기");
            System.out.println("10. 전체 회원 및 도서 목록 조회");
            System.out.println("0. 저장 및 종료");
            System.out.print("메뉴 선택: ");

            String choice = sc.nextLine().trim();

            if ("1".equals(choice)) {
                registerMember();
            } else if ("2".equals(choice)) {
                stockBook();
            } else if ("3".equals(choice)) {
                searchBooks();
            } else if ("4".equals(choice)) {
                rentBook();
            } else if ("5".equals(choice)) {
                returnBook();
            } else if ("6".equals(choice)) {
                viewOverdueMembers();
            } else if ("7".equals(choice)) {
                viewPopularityBooks();
            } else if ("8".equals(choice)) {
                viewHabitualOverdueMembers();
            } else if ("9".equals(choice)) {
                discardBooks();
            } else if ("10".equals(choice)) {
                printAll();
            } else if ("0".equals(choice)) {
                saveAndExit();
                return;
            } else {
                System.out.println("올바른 번호를 입력해주세요.");
            }
        }
    }

    // 회원 정보 콘솔 입력 및 등록
    private static void registerMember() {
        System.out.println("\n[신규 회원 등록]");
        System.out.print("회원명: ");
        String name = sc.nextLine().trim();

        System.out.print("연락처 (예: 010-1234-5678): ");
        String phone = sc.nextLine().trim();

        library.registerMember(name, phone);
        persist();
        System.out.println("회원 등록이 완료되었습니다.");
    }

    // 도서 정보 콘솔 입력 및 입고
    private static void stockBook() {
        System.out.println("\n[신규 도서 입고]");
        System.out.print("도서명: ");
        String title = sc.nextLine().trim();

        System.out.print("장르: ");
        String genre = sc.nextLine().trim();

        System.out.print("출판사명: ");
        String publisher = sc.nextLine().trim();

        System.out.print("저자: ");
        String author = sc.nextLine().trim();

        LocalDate publishDate = inputDate("출판일 (YYYY-MM-DD): ");

        int printEdition = inputInt("인쇄 회차 (숫자): ");

        LocalDate stockDate = inputDate("입고일 (YYYY-MM-DD, 오늘이면 엔터): ", true);

        int price = inputInt("가격 (원): ");

        System.out.print("책 고유번호(ISBN): ");
        String isbn = sc.nextLine().trim();

        library.stockBook(title, genre, publisher, author, publishDate, printEdition, stockDate, price, isbn);
        persist();
        System.out.println("도서 입고 및 관리 고유번호 발급이 완료되었습니다.");
    }

    // 도서 검색
    private static void searchBooks() {
        System.out.println("\n[도서 검색]");
        System.out.print("검색어 입력 (출판사 / 저자 / 장르): ");
        String keyword = sc.nextLine().trim();

        List<Book> results = library.searchBooks(keyword);
        if (results.isEmpty()) {
            System.out.println("검색 결과가 없습니다.");
        } else {
            System.out.println("--- 검색 결과 (ISBN 기준 중복 제거 1권씩 노출) ---");
            results.forEach(System.out::println);
        }
    }

    // 도서 대여
    private static void rentBook() {
        System.out.println("\n[도서 대여]");
        System.out.print("대여할 회원의 이름: ");
        String memberName = sc.nextLine().trim();

        System.out.print("대여할 도서의 관리 고유번호 (예: LIB-XXXXXX): ");
        String managementId = sc.nextLine().trim();

        LocalDate rentDate = inputDate("대여일 (YYYY-MM-DD, 오늘이면 엔터): ", true);

        boolean success = library.rentBook(managementId, memberName, rentDate);
        if (success) {
            persist();
            System.out.println("도서 대여가 성공적으로 처리되었습니다. (대여기간: 7일)");
        } else {
            System.out.println("대여 실패: 회원이 존재하지 않거나 연체 3회 이상으로 제한되었거나, 책이 이미 대여/폐기 상태입니다.");
        }
    }

    // 도서 반납
    private static void returnBook() {
        System.out.println("\n[도서 반납]");
        System.out.print("반납하는 회원의 이름: ");
        String memberName = sc.nextLine().trim();

        System.out.print("반납할 도서의 관리 고유번호: ");
        String managementId = sc.nextLine().trim();

        LocalDate returnDate = inputDate("실제 반납일 (YYYY-MM-DD, 오늘이면 엔터): ", true);

        boolean success = library.returnBook(managementId, memberName, returnDate);
        if (success) {
            persist();
            System.out.println("반납 처리가 완료되었습니다.");
        } else {
            System.out.println("반납 실패: 회원 정보 또는 대여 중인 해당 관리번호의 도서를 찾을 수 없습니다.");
        }
    }

    // 반납기간 도래 및 연체 회원 조회
    private static void viewOverdueMembers() {
        System.out.println("\n[반납기간 도래 및 연체 회원 목록]");
        LocalDate checkDate = inputDate("기준 날짜 (YYYY-MM-DD, 오늘이면 엔터): ", true);

        List<Member> members = library.getMembersWithDueOrOverdueBooks(checkDate);
        if (members.isEmpty()) {
            System.out.println("반납 임박 또는 연체 중인 회원이 없습니다.");
        } else {
            members.forEach(System.out::println);
        }
    }

    // 인기 / 비인기 도서
    private static void viewPopularityBooks() {
        System.out.println("\n[인기 / 비인기 도서 현황]");
        int count = inputInt("조회할 권수 입력 (예: 5): ");

        System.out.println("\n--- 인기 도서 TOP " + count + " ---");
        library.getPopularBooks(count).forEach(System.out::println);

        System.out.println("\n--- 비인기 도서 TOP " + count + " ---");
        library.getUnpopularBooks(count).forEach(System.out::println);
    }

    // 상습 미반납 회원
    private static void viewHabitualOverdueMembers() {
        System.out.println("\n[상습 미반납 회원 목록 (연체 3회 이상)]");
        List<Member> list = library.getHabitualOverdueMembers();
        if (list.isEmpty()) {
            System.out.println("상습 미반납 회원이 없습니다.");
        } else {
            list.forEach(System.out::println);
        }
    }

    // 10년 경과 도서 폐기
    private static void discardBooks() {
        int currentYear = LocalDate.now().getYear();
        System.out.print("\n기준 연도 (기본: " + currentYear + ", 엔터 시 현재 연도): ");
        String line = sc.nextLine().trim();
        int year = line.isEmpty() ? currentYear : Integer.parseInt(line);

        int before = library.getBookList().size();
        library.discardOldBooks(year);
        int after = library.getBookList().size();

        persist();
        System.out.println("폐기 완료: 총 " + (before - after) + "권의 도서가 폐기되어 목록에서 제외되었습니다.");
    }

    // 전체 목록 조회
    private static void printAll() {
        System.out.println("\n=== 등록 회원 전체 (" + library.getMemberList().size() + "명) ===");
        library.getMemberList().forEach(System.out::println);

        System.out.println("\n=== 보유 도서 전체 (" + library.getBookList().size() + "권) ===");
        library.getBookList().forEach(System.out::println);
    }

    // 안전한 날짜 입력 도우미
    private static LocalDate inputDate(String prompt) {
        return inputDate(prompt, false);
    }

    private static LocalDate inputDate(String prompt, boolean allowDefaultToday) {
        while (true) {
            System.out.print(prompt);
            String input = sc.nextLine().trim();
            if (allowDefaultToday && input.isEmpty()) {
                return LocalDate.now();
            }
            try {
                return LocalDate.parse(input);
            } catch (DateTimeParseException e) {
                System.out.println("날짜 형식이 잘못되었습니다. YYYY-MM-DD 형식으로 입력하세요.");
            }
        }
    }

    // 안전한 숫자 입력 도우미
    private static int inputInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = sc.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("숫자만 입력해주세요.");
            }
        }
    }

    // 자동 저장
    private static void persist() {
        try {
            library.saveData(DATA_FILE);
        } catch (Exception e) {
            System.out.println("[경고] 데이터 저장 실패: " + e.getMessage());
        }
    }

    // 종료 시 저장
    private static void saveAndExit() {
        persist();
        System.out.println("모든 데이터가 파일에 안전하게 저장되었습니다. 프로그램을 종료합니다.");
    }
}