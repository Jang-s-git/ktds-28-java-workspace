import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Book implements Serializable {
    private static final long serialVersionUID = 1L;

    private String title;
    private String genre;
    private String publisher;
    private String author;
    private LocalDate publishDate;
    private int printEdition;
    private LocalDate stockDate;
    private int price;
    private String isbn;
    private String managementId; // 도서관 고유 관리번호
    private int totalRentalCount;
    private boolean rented;
    private LocalDate rentalDate;
    private boolean returned;
    private LocalDate returnDate;
    private String rentedMemberName;
    private boolean discarded; // 폐기 여부

    public Book(String title, String genre, String publisher, String author,
                LocalDate publishDate, int printEdition, LocalDate stockDate, int price,
                String isbn, String managementId) {
        this.title = title;
        this.genre = genre;
        this.publisher = publisher;
        this.author = author;
        this.publishDate = publishDate;
        this.printEdition = printEdition;
        this.stockDate = stockDate;
        this.price = price;
        this.isbn = isbn;
        this.managementId = managementId;
        this.totalRentalCount = 0;
        this.rented = false;
        this.returned = true;
        this.discarded = false;
    }

    // 대여 처리 (기본 대여기간 7일)
    public void rent(String memberName, LocalDate rentDate) {
        this.rented = true;
        this.returned = false;
        this.rentalDate = rentDate;
        this.returnDate = rentDate.plusDays(7);
        this.rentedMemberName = memberName;
        this.totalRentalCount++;
    }

    // 반납 처리
    public void returnBook() {
        this.rented = false;
        this.returned = true;
        this.rentedMemberName = null;
    }

    public String getTitle() { return title; }
    public String getGenre() { return genre; }
    public String getPublisher() { return publisher; }
    public String getAuthor() { return author; }
    public LocalDate getPublishDate() { return publishDate; }
    public String getIsbn() { return isbn; }
    public String getManagementId() { return managementId; }
    public int getTotalRentalCount() { return totalRentalCount; }
    public boolean isRented() { return rented; }
    public LocalDate getRentalDate() { return rentalDate; }
    public LocalDate getReturnDate() { return returnDate; }
    public boolean isDiscarded() { return discarded; }
    public void setDiscarded(boolean discarded) { this.discarded = discarded; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return Objects.equals(managementId, book.managementId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(managementId);
    }

    @Override
    public String toString() {
        return String.format("[%s] %s (저자: %s, 출판사: %s, 장르: %s, ISBN: %s, 대여수: %d회, 대여중: %s)",
                managementId, title, author, publisher, genre, isbn, totalRentalCount, rented ? "Y" : "N");
    }
}