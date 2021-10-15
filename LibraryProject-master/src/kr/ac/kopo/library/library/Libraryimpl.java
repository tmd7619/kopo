package kr.ac.kopo.library.library;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


public class Libraryimpl implements Library {
	private List<BookVO> bookList = new ArrayList<BookVO>();
	private List<BorrowVO> borrowList = new ArrayList<BorrowVO>();

	Scanner sc = new Scanner(System.in);
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	public Libraryimpl() throws ParseException {
		try {
			File fl = new File("data/book.txt");
			FileReader flr = new FileReader(fl);
			BufferedReader blr = new BufferedReader(flr);
			String line = "";
			while ((line = blr.readLine()) != null) {
				String[] lineSplit = line.split("\t");
				BookVO bvo = new BookVO();
				bvo.setBookNum(Integer.parseInt(lineSplit[0]));
				bvo.setBookName(lineSplit[1]);
				bvo.setAuthor(lineSplit[2]);
				bvo.setPublisher(lineSplit[3]);
				bvo.setPublicDate(sdf.parse(lineSplit[4]));
				bvo.setBookStock(Integer.parseInt(lineSplit[5]));
				bookList.add(bvo);
			}
			blr.close();
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}
		try {

			BufferedReader in = new BufferedReader(new FileReader("data/Borrow.txt"));
			String line;

			while ((line = in.readLine()) != null) {

				BorrowVO bo = new BorrowVO();

				String[] lineSplit = line.split("\t");

				bo.setUserid(lineSplit[0]);
				bo.setBookname(lineSplit[1]);
				bo.setDate(sdf.parse(lineSplit[2]));
				borrowList.add(bo);

			}

			in.close();

		} catch (FileNotFoundException e) {

		} catch (IOException e) {
		}
	}

	@Override
	public void bookLookup() {
		System.out.println("도서번호\t이름\t저자\t출판사\t출간일\t\t남은책권수");
		for (int i = 0; i < bookList.size(); i++) {
			System.out.println(bookList.get(i).getBookNum() + "\t" + bookList.get(i).getBookName() + "\t"
					+ bookList.get(i).getAuthor() + "\t" + bookList.get(i).getPublisher() + "\t"
					+ sdf.format(bookList.get(i).getPublicDate()) + "\t" + bookList.get(i).getBookStock());
		}

	}
	/*
	 * ---------------------------------- admin libraryUtil ----------------------------------------------------------------------
	 */

	@Override // 도서 수정
	public void bookUpdate() {
		Loop1: while (true) {
			String oldString;
			String newString;

			System.out.println("1.도서이름 수정 2.저자 수정 3.출판사 수정 4.뒤로가기 ");
			int inputNum = sc.nextInt();
			sc.nextLine();
			switch (inputNum) {
			case 1:
				System.out.print("수정할 책이름을 입력하세요 : ");
				oldString = sc.nextLine();
				for (int i = 0; i < bookList.size(); i++) {
					if (oldString.equals(bookList.get(i).getBookName())) {
						System.out.print("새로 변경할 책이름을 입력하세요 : ");
						newString = sc.nextLine();
						bookList.get(i).setBookName(newString);
						System.out.println(newString + "으로 책이름 변경이 완료되었습니다. ");
						break;
					}
				}
				break;
			case 2:
				System.out.print("수정할 저자명을 입력하세요 : ");
				oldString = sc.nextLine();
				for (int i = 0; i < bookList.size(); i++) {
					if (oldString.equals(bookList.get(i).getAuthor())) {
						System.out.print("새로 변경할 저자 이름 입력하세요 : ");
						newString = sc.nextLine();
						bookList.get(i).setAuthor(newString);
						System.out.println(newString + "으로 저자명 변경이 완료되었습니다. ");
						break;
					}
				}
				break;
			case 3:
				System.out.print("수정할 출판사명을 입력하세요 : ");
				oldString = sc.nextLine();
				for (int i = 0; i < bookList.size(); i++) {
					if (oldString.equals(bookList.get(i).getPublisher())) {
						System.out.print("새로 변경할 출판사명을 입력하세요 : ");
						newString = sc.nextLine();
						bookList.get(i).setPublisher(newString);
						System.out.println(newString + "으로 출판사명 변경이 완료되었습니다. ");
						break;
					}
				}
				break;
			case 4:
				bookInfoUpdate();
				break Loop1;
			default:
				System.out.println("잘못된 값을 입력하셨습니다. 다시 입력하세요.");
				continue;
			}

		}

	}

	@Override
	public void bookDelete() {
		String BookName;
		String ans;
		System.out.print("삭제할 책이름을 입력하세요 : ");
		BookName = sc.nextLine();
		for (int i = 0; i < bookList.size(); i++) {
			if (BookName.equals(bookList.get(i).getBookName())) {
				System.out.print("정말로 삭제하시겠습니까? (y/n) : ");
				ans = sc.nextLine();
				if (ans.equals("y") || ans.equals("Y")) {
					bookList.remove(i);
					System.out.println(BookName + "의 모든 데이터가 삭제되었습니다.");
					bookInfoUpdate();
					break;
				} else {
					System.out.println("삭제를 취소하셨습니다. 전단계로 돌아갑니다.");
					break;
				}
			}
		}
	}
	
	@Override
	public void bookAdd() throws ParseException { // 도서 등록
	
			BookVO newbv = new BookVO();
			int BookNum = bookList.size()+1;
			String bookName;
			String author;
			String publisher;
			String publicDate;
			String bookStock;
			
			while (true) {
				System.out.print("등록하실 책이름을 입력하세요. : ");
				bookName = sc.nextLine();
				boolean overlap = false;
				for (int i = 0; i < bookList.size(); i++) {

					if (bookList.get(i).getBookName().equals(bookName)) {
						overlap = true;
						break;
					}
				}
				if (overlap == true) {
					System.out.println("이미 존재하는 도서입니다. 다시 입력하세요.");
					System.out.println();
					continue;
				}
				break;
			}

			System.out.print("저자를 입력해주세요 : ");
			author = sc.nextLine();

			System.out.print("출판사를 입력해주세요 : ");
			publisher = sc.nextLine();

			System.out.print("출간일을 입력해주세요. ex)1995-11-26: ");
			publicDate = sc.nextLine();

			System.out.print("추가하실 책 개수를 입력해주세요. : ");
			bookStock = sc.nextLine();
			
			newbv.setBookNum(BookNum);
			newbv.setBookName(bookName);
			newbv.setAuthor(author);
			newbv.setPublisher(publisher);
			newbv.setPublicDate(sdf.parse(publicDate));
			newbv.setBookStock(Integer.parseInt(bookStock));


			bookList.add(newbv);
			bookInfoUpdate();
			System.out.println("정상적으로 도서등록이 완료되었습니다.");
	}
	
	

	/*
	 * ---------------------------------- admin libraryUtil -----------------------------------------------------------------------
	 * 
	 * 										
	 */

	/*
	 * ---------------------------------- user libraryUtil --------------------------------------------------------------------------
	 */
	@Override
	public void bookBorrow(String userid) {
		int bookNum;
		String ans;
		System.out.print("1.도서번호로 대출하기 2.책이름으로 대출하기 3.뒤로가기 : ");
		int inputNum = sc.nextInt();
		sc.nextLine();

		if (inputNum == 1) { // 도서번호로 대출하기
			Loop: while (true) {
				bookLookup();
				System.out.print("대출하실 도서번호를 입력하세요 : ");
				bookNum = sc.nextInt();
				sc.nextLine();
				for (int i = 0; i < bookList.size(); i++) {
					if (bookNum == bookList.get(i).getBookNum()) {
						if (bookList.get(i).getBookStock() != 0) {
							while (true) {
								System.out.print(bookList.get(i).getBookName() + " 도서를 대출하시겠습니까? (y/n) : ");
								ans = sc.nextLine();
								if (ans.equals("y") || ans.equals("Y")) {
									System.out.println("성공적으로 " + bookList.get(i).getBookName() + " 도서 대출이 완료되었습니다.");

									bookList.get(i).minusBookStock(); // 도서 재고-1

									Date today = new Date();
									BorrowVO bvo = new BorrowVO();
									bvo.setUserid(userid);
									bvo.setBookname(bookList.get(i).getBookName());
									bvo.setDate(today);

									borrowList.add(bvo); // 대출정보 저장
									borrowInfoUpdate();
									break Loop;
								} else if (ans.equals("n") || ans.equals("N")) {
									System.out.println("대출하기를 취소하셨습니다. 전단계로 이동합니다.");
									break Loop;
								} else {
									System.out.println("잘못 입력하셨습니다. 다시 입력하세요. (y/n)");
									continue;
								}
							}
						} else {
							System.out.println("현재 남아있는 권수가 0입니다. 다음에 이용해주세요.");
							System.out.println();
							System.out.println();
							continue Loop;
						}
					}
				}
			}
		} else if (inputNum == 2) { // 책이름으로 조회하기
			String bookName;
			Loop3: while (true) {
				bookLookup();
				System.out.print("대출하실 도서이름을 입력하세요 : ");
				bookName = sc.nextLine();
				for (int i = 0; i < bookList.size(); i++) {
					if (bookName.equals(bookList.get(i).getBookName())) {
						if (bookList.get(i).getBookStock() != 0) {
							while (true) {
								System.out.print(bookList.get(i).getBookName() + " 도서를 대출하시겠습니까? (y/n) : ");
								ans = sc.nextLine();
								if (ans.equals("y") || ans.equals("Y")) {
									System.out.println("성공적으로 " + bookList.get(i).getBookName() + " 도서 대출이 완료되었습니다.");

									bookList.get(i).minusBookStock(); // 도서 재고 -1

									Date today = new Date();
									BorrowVO bvo = new BorrowVO();
									bvo.setUserid(userid);
									bvo.setBookname(bookList.get(i).getBookName());
									bvo.setDate(today);

									borrowList.add(bvo); // 대출정보 저장
									borrowInfoUpdate();

									break Loop3;
								} else if (ans.equals("n") || ans.equals("N")) {
									System.out.println("대출하기를 취소하셨습니다. 전단계로 이동합니다.");
									break Loop3;
								} else {
									System.out.println("잘못 입력하셨습니다. 다시 입력하세요. (y/n)");
									continue;
								}
							}
						} else {
							System.out.println("현재 남아있는 권수가 0입니다. 다음에 이용해주세요.");
							System.out.println();
							System.out.println();
							continue Loop3;
						}
					}
				}
			}
		}
		bookInfoUpdate();
	}

	@Override
	public void borrowInfo(String userId) {
		System.out.println("******현재 대출 중인 도서 ******");
		System.out.println("책이름\t대출날짜");

		for (int i = 0; i < borrowList.size(); i++) {
			if (borrowList.get(i).getUserid().equals(userId)) {
				System.out.println(borrowList.get(i).getBookname() + "\t" + sdf.format(borrowList.get(i).getDate()));
			}
		}
		System.out.println("************************");

	}

	@Override
	public void bookReturn(String userId) {

		String bookName;

		System.out.println("******현재 대출 중인 도서 ******");
		System.out.println("책이름\t대출날짜");

		for (int i = 0; i < borrowList.size(); i++) {
			if (borrowList.get(i).getUserid().equals(userId)) {
				System.out.println(borrowList.get(i).getBookname() + "\t" + sdf.format(borrowList.get(i).getDate()));
			}
		}
		System.out.println("************************");
		System.out.println();

		Loop: while (true) {
			System.out.print("반납하실 책이름을 입력해주세요 : ");
			bookName = sc.nextLine();
			
			for (int i = 0; i < borrowList.size(); i++) {
				if (borrowList.get(i).getUserid().equals(userId) && borrowList.get(i).getBookname().equals(bookName)) {
					System.out.println(bookName + " 책을 반납하겠습니다. 이용해주셔서 감사합니다.");
					for(int j = 0 ; j < bookList.size(); j ++ ) {
						if(bookList.get(j).getBookName().equals(borrowList.get(i).getBookname())) {
							bookList.get(j).plusBookStock();	// 재고 증가
							break;
						}
					}
					borrowList.remove(i);
					borrowInfoUpdate(); // borrow.txt update
					bookInfoUpdate(); // book.txt update
					break Loop;
				}
			}
			System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
		}

	}

	/*
	 * ---------------------------------- user libraryUtil --------------------------------------------------------------------------
	 */

	
	
	public void bookInfoUpdate() {
		File file = new File("data/book.txt");
		if (file.exists()) {
			file.delete();
		}
		try {
			if (!file.exists())
				file.createNewFile();
			FileWriter fw = new FileWriter("data/book.txt", true);
			BufferedWriter bw = new BufferedWriter(fw);

			for (int i = 0; i < bookList.size(); i++) {

				String line = bookList.get(i).getBookNum() + "\t" + bookList.get(i).getBookName() + "\t"
						+ bookList.get(i).getAuthor() + "\t" + bookList.get(i).getPublisher() + "\t"
						+ sdf.format(bookList.get(i).getPublicDate()) + "\t" + bookList.get(i).getBookStock();

				if (i != 0)
					bw.newLine();
				bw.write(line);
				bw.flush();
			}

			fw.close();
			bw.close();

		} catch (IOException e) {
			System.out.println(e);
		}
	}

	public void borrowInfoUpdate() {
		File file = new File("data/borrow.txt");
		if (file.exists()) {
			file.delete();
		}
		try {
			if (!file.exists())
				file.createNewFile();
			FileWriter fw = new FileWriter("data/borrow.txt", true);
			BufferedWriter bw = new BufferedWriter(fw);

			for (int i = 0; i < borrowList.size(); i++) {

				String line = borrowList.get(i).getUserid() + "\t" + borrowList.get(i).getBookname() + "\t"
						+ sdf.format(borrowList.get(i).getDate());

				if (i != 0)
					bw.newLine();
				bw.write(line);
				bw.flush();
			}

			fw.close();
			bw.close();

		} catch (IOException e) {
			System.out.println(e);
		}

	}

}
