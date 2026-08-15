import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Member implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private String phone;
    private int fine;
    private int overdueCount;
    private List<Book> rentedBooks; // 회원이 대여한 도서 목록

    public Member(String name, String phone) {
        this.name = name;
        this.phone = phone;
        this.fine = 0;
        this.overdueCount = 0;
        this.rentedBooks = new ArrayList<>();
    }

    public void addFine(int amount) { this.fine += amount; }
    public void increaseOverdueCount() { this.overdueCount++; }
    public boolean isRentalRestricted() { return this.overdueCount >= 3; }

    public String getName() { return name; }
    public String getPhone() { return phone; }
    public int getFine() { return fine; }
    public int getOverdueCount() { return overdueCount; }
    public List<Book> getRentedBooks() { return rentedBooks; }

    @Override
    public String toString() {
        return String.format("회원명: %s | 연락처: %s | 벌금: %d원 | 연체횟수: %d회 | 대여권수: %d권",
                name, phone, fine, overdueCount, rentedBooks.size());
    }
}