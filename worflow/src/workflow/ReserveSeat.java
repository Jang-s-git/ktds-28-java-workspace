package workflow;

public class ReserveSeat {

	public static void main(String[] args) {
		
		int[] seats = new int[50];
		
		int n = 0;
		int m = 0;
		
		// 랜덤하게 좌석을 배정
		// 0 <-- 에약 가능한 좌석.
		// 1 <-- 예약 불가능한 좌석.
		for (int i = 0; i < seats.length; i++) {
			seats[i] = (int) (Math.random() * 2);
		}
		
		for (int i = 0; i < seats.length; i++) {
			
			// 배열의 값을 출력
			// 0 0 1 0 1 1 1 1 0 1 0 1 0 0 1 ...
			System.out.print(seats[i] + " ");
			
			// 예약 가능한 좌석의 수를 출력
			// "n개의 좌석을 예약할 수 있습니다."
			if (seats[i]==0) {
				n++;
			}
			
			// 예약 불가능한 좌석의 수 출력
			// "m개의 좌석이 이미 예약되어 있습니다."
			if (seats[i]==1) {
				m++;
			}
			
		}
		System.out.println("\n" + n + "개의 좌석을 예약할 수 있습니다.");
		System.out.println(m + "개의 좌석이 이미 예약되어 있습니다.");
		
		
		// longText 문자열 변수에 's'가 몇 개 있는 지 세어보기
		String longText = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since 1966, when designers at Letraset and James Mosley, the librarian at St Bride Printing Library in London, took a 1914 Cicero translation and scrambled it to make dummy text for Letraset's Body Type sheets. It has survived not only many decades, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised thanks to these sheets and more recently with desktop publishing software like Aldus PageMaker and Microsoft Word including versions of Lorem Ipsum.";
		char[] letters = longText.toCharArray();
		
		// character는 홑따옴표('')로 작성
		// 'a', 's', ...
		int s = 0;
		for (int i = 0; i < letters.length; i++) {
			if (letters[i] == 's') {
				s++;
			}
		}
		System.out.println(s);
		
	}
}
