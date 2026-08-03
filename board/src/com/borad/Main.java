package com.borad;

import java.util.Scanner;

import com.borad.domain.Board;
import com.borad.impl.BoardImpl;
import com.borad.impl.CommentImpl;
import com.borad.inf.BoardService;
import com.borad.inf.CommentService;

public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		BoardService boardService = new BoardImpl();
		CommentService commentService = new CommentImpl();
		
		while(true) {
			System.out.println("==== 게시판 ====");
			System.out.println("1. 게시글 작성 | 2. 전체 목록 | 3. 게시글 조회 | 4. 게시글 수정 | 5. 게시글 삭제");
			System.out.println("6. 게시글 수 | 7. 댓글 작성 | 8. 댓글 삭제 | 9. 댓글 추천 | 10. 게시글 검색");
			System.out.println("11. 게시글 전체 삭제 | 12. 댓글 전체 삭제 | 0. 종료");
			System.out.println("실행시킬 메뉴를 선택해주세요.");
			
			int menu;
			try {
				menu = Integer.parseInt(scanner.nextLine());
			} catch(NumberFormatException nfe) {
				System.out.println("숫자만 입력해주세요.");
				continue;
			}
			
			if (menu == 1) {
				// 1. 게시글 작성
				System.out.println("제목: ");
				String title = scanner.nextLine();
				System.out.println("작성자: ");
				String writer = scanner.nextLine();
				System.out.println("날짜: ");
				String date = scanner.nextLine();
				System.out.println("내용: ");
				String content = scanner.nextLine();
				boardService.add(title, writer, date, content);
			} else if (menu == 2) {
				// 2. 전체 목록
				boardService.printAll();
			} else if (menu == 3) {
				// 3. 게시글 조회
				System.out.println("조회할 게시글 번호: ");
				try {
					int index = Integer.parseInt(scanner.nextLine());
					
					Board board = boardService.getBoard(index);
					if (board == null) {
						System.out.println("잘못된 게시글 번호입니다.");
					} else {
						boardService.print(index);
						commentService.printComment(board.getComments());
					}
				} catch(NumberFormatException nfe) {
					System.out.println("숫자만 입력해주세요.");
				}
			} else if (menu == 4) {
				// 4. 게시글 수정
				System.out.println("수정할 게시글 번호: ");
				try {
					int index = Integer.parseInt(scanner.nextLine());
					
					Board board = boardService.getBoard(index);
					if (board == null) {
						System.out.println("잘못된 게시글 번호입니다.");
					} else {
						System.out.println("수정할 제목: ");
						String title = scanner.nextLine();
						System.out.println("수정할 내용: ");
						String content = scanner.nextLine();
						boardService.update(index, title, content);
					}
				} catch(NumberFormatException nfe) {
					System.out.println("숫자만 입력해주세요.");
				}
			} else if (menu == 5) {
				// 5. 게시글 삭제
				System.out.println("삭제할 게시글 번호: ");
				try {
					int index = Integer.parseInt(scanner.nextLine());
					
					Board board = boardService.getBoard(index);
					if (board == null) {
						System.out.println("잘못된 게시글 번호입니다.");
					} else {
						boardService.delete(index);
						// 해당 게시글의 댓글도 전부 삭제
						commentService.deleteAllComment(board.getComments());
					}
				} catch(NumberFormatException nfe) {
					System.out.println("숫자만 입력해주세요.");
				}
			} else if (menu == 6) {
				// 6. 게시글 수
				boardService.count();
			} else if (menu == 7) {
				// 7. 댓글 작성
				System.out.println("댓글을 작성할 게시글 번호: ");
				try {
					int index = Integer.parseInt(scanner.nextLine());
					
					Board board = boardService.getBoard(index);
					if (board == null) {
						System.out.println("잘못된 게시글 번호입니다.");
					} else {
						System.out.println("댓글 내용: ");
						String content = scanner.nextLine();
						System.out.println("댓글 작성자: ");
						String writer = scanner.nextLine();
						System.out.println("댓글 작성 날짜: ");
						String date = scanner.nextLine();
						commentService.addComment(board.getComments(), content, writer, date);
					}
				} catch(NumberFormatException nfe) {
					System.out.println("숫자만 입력해주세요.");
				}
			} else if (menu == 8) {
				// 8. 댓글 삭제
				System.out.println("댓글을 삭제할 게시글 번호: ");
				try {
					int index = Integer.parseInt(scanner.nextLine());
					
					Board board = boardService.getBoard(index);
					if (board == null) {
						System.out.println("잘못된 게시글 번호입니다.");
					} else {
						System.out.println("삭제할 댓글 번호: ");
						int i = Integer.parseInt(scanner.nextLine());
						commentService.deleteComment(board.getComments(), i);
					}
				} catch(NumberFormatException nfe) {
					System.out.println("숫자만 입력해주세요.");
				}
			} else if (menu == 9) {
				// 9. 댓글 추천
				System.out.println("댓글을 추천할 게시글 번호: ");
				try {
					int index = Integer.parseInt(scanner.nextLine());
					
					Board board = boardService.getBoard(index);
					if (board == null) {
						System.out.println("잘못된 게시글 번호입니다.");
					} else {
						System.out.println("추천할 댓글 번호: ");
						int i = Integer.parseInt(scanner.nextLine());
						commentService.recommendComment(board.getComments(), i);
					}
				} catch(NumberFormatException nfe) {
					System.out.println("숫자만 입력해주세요.");
				}
			} else if (menu == 10) {
				// 10. 게시글 검색
				System.out.println("검색어 입력: ");
				String keyword = scanner.nextLine();
				boardService.search(keyword);
			} else if (menu == 11) {
				// 11. 게시글 전체 삭제
				boardService.deleteAll();
			} else if (menu == 12) {
				// 12. 댓글 전체 삭제
				System.out.println("댓글 전체를 삭제할 게시글 번호: ");
				try {
					int index = Integer.parseInt(scanner.nextLine());
					
					Board board = boardService.getBoard(index);
					if (board == null) {
						System.out.println("잘못된 게시글 번호입니다.");
					} else {
						commentService.deleteAllComment(board.getComments());
					}
				} catch(NumberFormatException nfe) {
					System.out.println("숫자만 입력해주세요.");
				}
			} else if (menu == 0) {
				// 0. 종료
				System.out.println("시스템을 종료합니다.");
				break;
			} else {
				System.out.println("올바른 메뉴 번호를 입력해주세요.");
				continue;
			}
			
		}
	}
}
