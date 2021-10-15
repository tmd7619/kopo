package kr.ac.kopo.library.main;

import java.text.ParseException;
import java.util.Scanner;

import kr.ac.kopo.library.library.Libraryimpl;
import kr.ac.kopo.library.member.Memberimpl;

public class LibraryMain {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		Memberimpl m = new Memberimpl();
		Libraryimpl l = new Libraryimpl();
		int inputNum;

		while (true) {
			System.out.print("1.로그인하기 2.회원가입 3.종료 : ");
			String input = sc.nextLine();

			if (input.equals("1")) { // 로그인하기

				Loop1: while (true) {

					System.out.print("로그인 아이디 입력 : ");
					String logId = sc.nextLine();
					System.out.print("로그인 비밀번호 입력 : ");
					String logPasswd = sc.nextLine();

/*
 *--------------------------------관리자 mode -----------------------------------------------------------------------------------			
 */
					if (logId.equals("admin") && logPasswd.equals("1234")) { // 관리자가 맞으면,
						System.out.println("관리자 모드로 진입하셨습니다.");
						while (true) {
							System.out.print("1.회원관리 2.도서관리 3.뒤로가기 : ");
							inputNum = sc.nextInt();
							sc.nextLine();
							if (inputNum == 1) { // 회원관리 실행
								Loop2: while (true) {
									System.out.print("1.회원조회 2.회원정보 수정 3.회원삭제 4.뒤로가기 : ");
									inputNum = sc.nextInt();
									sc.nextLine();
									switch (inputNum) {
									case 1:
										System.out.println("회원조회를 선택하셨습니다");
										m.adminMemberLookup();
										break;
									case 2:
										System.out.println("회원정보 수정을 선택하셨습니다.");
										m.adminMemberUpdate();
										break;
									case 3:
										System.out.println("회원삭제를 선택하셨습니다.");
										m.adminMemberDelete();
										break;
									case 4:
										System.out.println("뒤로가기를 선택하셨습니다.");
										break Loop2;
									default:
										System.out.println("잘못된 값을 입력하셨습니다. 다시 입력하세요.");
										continue;
									}

								}
							} else if (inputNum == 2) { // 도서관리 실행
								Loop3: while (true) {
								 
									System.out.print("1.도서조회 2.도서등록 3.도서수정 4.도서삭제 5.뒤로가기 : ");
									inputNum = sc.nextInt();
									sc.nextLine();
									switch (inputNum) {
									case 1:
										System.out.println("도서조회 선택하셨습니다");
										l.bookLookup();
										break;
									case 2:
										System.out.println("도서등록을 선택하셨습니다.");
										l.bookAdd();
										break;
									case 3:
										System.out.println("도서수정을 선택하셨습니다.");
										l.bookUpdate();
										break;
									case 4:
										System.out.println("도서삭제 선택하셨습니다.");
										l.bookDelete();
										break;
									case 5:
										System.out.println("뒤로가기를 선택하셨습니다.");
										break Loop3;
									default:
										System.out.println("잘못된 값을 입력하셨습니다. 다시 입력하세요.");
										continue;
									}

								}
							} else if (inputNum == 3) {
								System.out.println("뒤로가기를 선택하셨습니다. 로그인화면으로 돌아갑니다.");
								break;
							} else {
								System.out.println("잘못 입력하셨습니다. 다시 입력하세요.");
								continue;
							}

						}

						break;
/*
*--------------------------------관리자 mode -----------------------------------------------------------------------------------			
*/
						
						
						
/*
*--------------------------------사용자 mode -----------------------------------------------------------------------------------			
*/
						
						
					} else {
						m.userSwitch(logId, logPasswd);

						if (m.getMem() == null) {	// 로그인 x
							System.out.println("잘못된 로그인 정보입니다. 다시 입력해주세요.");
						}
						
						// 로그인처리 ok, 기능수행
						else { 
							System.out.println(logId+"님 환영합니다 !");
							while (true) {

								while (true) {
									System.out.print("1.내정보 관리 2.도서 관리 3.뒤로가기 : ");
									inputNum = sc.nextInt();
									sc.nextLine();
									if (inputNum == 1) { // 회원관리 실행

										while (true) {
											System.out.print("1.내정보 조회 2.내정보 수정 3.회원탈퇴 4.뒤로가기 : ");
											inputNum = sc.nextInt();
											sc.nextLine();
											int cnt = 0;

											while (true) {

												if (inputNum == 1) {
													System.out.println("내정보 조회를 선택하셨습니다");
													m.userMemberLookup(); // memberVO 정보 조회
													if(m.getMem().getBorrowCnt() != 0) { // 대출중인 권수가 0이 아닐때만 조회하기 
													l.borrowInfo(m.getMem().getUserId()); // borrow 정보 조회
													}
													break;

												} else if (inputNum == 2) {
													System.out.println("내정보 수정을 선택하셨습니다.");
													m.userMemberUpdate();
													break;

												} else if (inputNum == 3) {
													System.out.println("회원탈퇴를 선택하셨습니다.");

													m.userMemberDelete();

													if (m.getMem() == null) {
														break Loop1;
													}

												} else if (inputNum == 4) {
													System.out.println("뒤로가기를 선택하셨습니다.");
													cnt = 1;
													break;

												} else {
													System.out.println("잘못 입력하셨습니다. 다시 입력하세요.");
													break;
												}

											}

											if (cnt == 1)
												break;
										}

									} else if (inputNum == 2) { // 도서관리 실행
										while (true) {
											System.out.print("1.도서목록 조회 2.대출하기 3.반납하기 4.뒤로가기 : ");
											inputNum = sc.nextInt();
											sc.nextLine();

											if (inputNum == 1) {
												l.bookLookup();
											} else if (inputNum == 2) {
												if (m.getMem().getBorrowCnt() == 3) { // 현재 유저가 빌리고 있는 책이 3권일경우, 대출개수
																						// 초과로 더이상 대출 불가능
													System.out.println("가능한 대출 개수를 초과하셨습니다. 다음에 또 이용해주십시오.");
												} else { // 대출 실행
													l.bookBorrow(m.getMem().getUserId());
													m.getMem().plusBorrowCnt(); // 책을 빌리면 사용자의 대출 권수 +1
													m.infoUpdate();					// 
												}
											} else if (inputNum == 3) {
												if(m.getMem().getBorrowCnt() != 0) {
												l.bookReturn(m.getMem().getUserId());
												m.getMem().minusBorrowCnt();
												m.infoUpdate();
												} else{
													System.out.println("현재 대출중인 도서가 없습니다.");
													break;
												}
											} else if (inputNum == 4) {
												System.out.println("뒤로가기를 선택하셨습니다.");
												break;
											} else {
												System.out.println("잘못 입력하셨습니다. 다시 입력하세요.");
												continue;
											}

										}
										break;
									} else if (inputNum == 3) {
										System.out.println("뒤로가기를 선택하셨습니다. 로그인화면으로 돌아갑니다.");
										break Loop1;
									} else {
										System.out.println("잘못 입력하셨습니다. 다시 입력하세요.");
										continue;
									}

								}

							}
						}
					}
					
/*
*--------------------------------사용자 mode -----------------------------------------------------------------------------------			
*/

				}

			} else if (input.equals("2")) { // 회원가입
				m.register();
				continue;
			} else if (input.equals("3") ) {
				System.out.println("종료하겠습니다. 감사합니다");
				break;
			}else {
				System.out.println("잘못된 값을 입력하셨습니다. 다시 입력하세요.");
				continue;
			}

		}

	}
}
