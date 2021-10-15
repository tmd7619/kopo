package kr.ac.kopo.library.member;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Memberimpl implements Member {

	Scanner sc = new Scanner(System.in);
	private List<MemberVO> memberList = new ArrayList<MemberVO>(); // MemberVO 타입의 List 객체 생성
	private MemberVO mem;

	public Memberimpl() {
		mem = null;

		try {
			File fm = new File("data/Member.txt"); // 파일객체 생성
			FileReader fmr = new FileReader(fm); // 입력 스트림 생성
			BufferedReader bmr = new BufferedReader(fmr); // 입력 버퍼 생성 // 파일을 버퍼를 이용해서 읽는 이유는 문자를 효율적으로 입출력함
			String line = "";
			while ((line = bmr.readLine()) != null) { // line by line으로 읽기

				String[] lineSplit = line.split("\t"); // 탭을 기준으로 나눈 데이터를 임시로 저장할 배열 생성
				MemberVO mvo = new MemberVO(); // MemberVO 객체 생성 -> setter 메서드 쓰기 위함
				mvo.setUserId(lineSplit[0]); // MemberVO에 userid를 lineSplit[0]로 변경
				mvo.setPassword(lineSplit[1]);
				mvo.setName(lineSplit[2]);
				mvo.setEmail(lineSplit[3]);
				mvo.setPhoneNum(lineSplit[4]);
				mvo.setBorrowCnt(Integer.parseInt(lineSplit[5]));
				memberList.add(mvo);
			}
			bmr.close();
		} catch (FileNotFoundException e) {

		} catch (IOException e) {

		}

	}

	public MemberVO getMem() { // MemberVO 객체를 출력하는 메소드 = 현재 회원정보

		if (this.mem != null)
			return this.mem;

		return null;
	}

	/*
	 * ---------------------------------- admin memberUti ---------------------------------------------
	 */

	@Override // 관리자 회원조회
	public void adminMemberLookup() {
		// TODO Auto-generated method stub
		System.out.println("아이디\t비밀번호\t이름\t이메일\t\t\t연락처\t\t대출권수");
		for (int i = 1; i < memberList.size(); i++) {
			System.out.println(memberList.get(i).getUserId() + "\t" + memberList.get(i).getPassword() + "\t"
					+ memberList.get(i).getName() + "\t" + memberList.get(i).getEmail() + "\t"
					+ memberList.get(i).getPhoneNum() + "\t" + memberList.get(i).getBorrowCnt());
		}

	}

	@Override // 관리자 회원정보 수정
	public void adminMemberUpdate() {
		// TODO Auto-generated method stub
		Loop1: while (true) {
			String oldString;
			String newString;
			String againString;

			System.out.print("1.아이디 수정 2.비밀번호 수정 3.이름 수정 4.이메일 수정 5.연락처 수정 6.뒤로가기 : ");
			int inputNum = sc.nextInt();
			sc.nextLine();
			switch (inputNum) {
			case 1:
				System.out.print("수정할 아이디를 입력하세요 : ");
				oldString = sc.nextLine();
				for (int i = 0; i < memberList.size(); i++) {
					if (oldString.equals(memberList.get(i).getUserId())) {
						System.out.print("새로 변경할 아이디를 입력하세요 : ");
						newString = sc.nextLine();
						memberList.get(i).setUserId(newString);
						System.out.println(newString + "으로 아이디 변경이 완료되었습니다. ");
						break;
					}
				}
				break;
			case 2:
				System.out.print("비밀번호를 수정할 아이디를 입력하세요 : ");
				oldString = sc.nextLine();
				for (int i = 0; i < memberList.size(); i++) {
					if (oldString.equals(memberList.get(i).getUserId())) {
						while (true) {
							System.out.print("새로 변경할 비밀번호를 입력하세요 : ");
							newString = sc.nextLine();
							System.out.print("다시 한번 입력하세요 : ");
							againString = sc.nextLine();
							if (newString.equals(againString)) {
								memberList.get(i).setPassword(newString);
								System.out.println(newString + "으로 비밀번호 변경이 완료되었습니다. ");
								break;
							} else {
								System.out.println("비밀번호가 서로 다릅니다. 다시 입력해주세요");
								continue;
							}
						}
					}

				}
				break;
			case 3:
				System.out.print("수정할 이름을 입력하세요 : ");
				oldString = sc.nextLine();
				for (int i = 0; i < memberList.size(); i++) {
					if (oldString.equals(memberList.get(i).getName())) {
						System.out.print("새로 변경할 이름을 입력하세요 : ");
						newString = sc.nextLine();
						memberList.get(i).setName(newString);
						System.out.println(newString + "으로 이름 변경이 완료되었습니다. ");
						break;
					}
				}
				break;
			case 4:
				System.out.print("수정할 이메일을 입력하세요 : ");
				oldString = sc.nextLine();
				for (int i = 0; i < memberList.size(); i++) {
					if (oldString.equals(memberList.get(i).getEmail())) {
						System.out.print("새로 변경할 이메일을 입력하세요 : ");
						newString = sc.nextLine();
						memberList.get(i).setEmail(newString);
						System.out.println(newString + "으로 이메일 변경이 완료되었습니다. ");
						break;
					}
				}
				break;
			case 5:
				System.out.print("수정할 연락처를 입력하세요 : ");
				oldString = sc.nextLine();
				for (int i = 0; i < memberList.size(); i++) {
					if (oldString.equals(memberList.get(i).getPhoneNum())) {
						System.out.print("새로 변경할 연락처를 입력하세요(010-xxxx-xxxx) : ");
						newString = sc.nextLine();
						memberList.get(i).setPhoneNum(newString);
						System.out.println(newString + "으로 연락처 변경이 완료되었습니다. ");
						break;
					}
				}
				break;
			case 6:
				infoUpdate();
				break Loop1;

			default:
				System.out.println("잘못된 값을 입력하셨습니다. 다시 입력하세요.");
				continue;
			}

		}

	}

	public void adminMemberDelete() {
		String deleteId;
		String ans;
		System.out.print("삭제할 아이디를 입력하세요 : ");
		deleteId = sc.nextLine();
		for (int i = 0; i < memberList.size(); i++) {
			if (deleteId.equals(memberList.get(i).getUserId())) {
				System.out.print("정말로 삭제하시겠습니까? (y/n) : ");
				ans = sc.nextLine();
				if (ans.equals("y") || ans.equals("Y")) {
					memberList.remove(i);
					System.out.println(deleteId + "의 모든 데이터가 삭제되었습니다.");
					infoUpdate();
					break;
				} else {
					System.out.println("삭제를 취소하셨습니다. 전단계로 돌아갑니다.");
					break;
				}
			}
		}

	}

	/*
	 * * ---------------------------------- admin memberUti---------------------------------------------
	 * 
	 * 
	 * 
	 * /* ---------------------------------- user memberUtil---------------------------------------------
	 */

	@Override
	public void userSwitch(String logId, String logpasswd) throws ParseException { // admin <-> user 변경하기 위한 메서드

		for (int i = 0; i < memberList.size(); i++) {
			if (logId.equals(memberList.get(i).getUserId()) && logpasswd.equals(memberList.get(i).getPassword())) {
				mem = memberList.get(i);
				break;
			}
		}

	}

	@Override
	public void register() { // 회원가입

		try {
			MemberVO newMem = new MemberVO();
			String userId;
			String name;
			String email;
			String password;
			String phoneNum;
			int borrowCnt = 0;
			while (true) {
				System.out.print("사용하실 아이디를 입력해주세요. : ");
				userId = sc.nextLine();
				boolean overlap = false;
				for (int i = 0; i < memberList.size(); i++) {

					if (memberList.get(i).getUserId().equals(userId)) {
						overlap = true;
						break;
					}
				}
				if (overlap == true) {
					System.out.println("이미 존재하는 아이디입니다. 다시 입력하세요.");
					System.out.println();
					continue;
				}
				break;
			}

			System.out.print("이름을 입력해주세요 : ");
			name = sc.nextLine();

			System.out.print("휴대폰 번호를 입력해주세요 [010-xxxx-xxxx] : ");
			phoneNum = sc.nextLine();

			System.out.print("이메일을 입력해주세요  : ");
			email = sc.nextLine();

			System.out.print("사용하실 비밀번호를 입력해주세요. : ");
			password = sc.nextLine();
			System.out.println();

			newMem.setUserId(userId);
			newMem.setName(name);
			newMem.setPhoneNum(phoneNum);
			newMem.setEmail(email);
			newMem.setPassword(password);
			newMem.setBorrowCnt(0);

			memberList.add(newMem);

			FileWriter fw = new FileWriter("data/Member.txt", true);
			BufferedWriter bw = new BufferedWriter(fw);
			String line = userId + "\t" + password + "\t" + name + "\t" + email + "\t" + phoneNum + "\t"
					+ Integer.toString(borrowCnt);

			bw.newLine();
			bw.write(line);
			bw.flush();

			fw.close();
			bw.close();

		} catch (IOException e) {
			System.out.println(e);
		}

		System.out.println("회원가입에 성공하셨습니다.");

	}

	@Override
	public void userMemberLookup() { // 사용자 자기 정보 조회

		System.out.println("아이디\t비밀번호\t이름\t이메일\t\t\t연락처\t\t대출중인도서수");
		System.out.println(mem.getUserId() + "\t" + mem.getPassword() + "\t" + mem.getName() + "\t" + mem.getEmail()
				+ "\t" + mem.getPhoneNum() + "\t" + mem.getBorrowCnt());

	}

	@Override
	public void userMemberUpdate() { // 사용자 자기 정보 수정
		Loop1: while (true) {
			String inputString;
			String againString;
			System.out.print("1.아이디 수정 2.비밀번호 수정 3.이름 수정 4.이메일 수정 5.연락처 수정 6.뒤로가기 : ");
			int inputNum = sc.nextInt();
			sc.nextLine();
			switch (inputNum) {
			case 1:
				System.out.print("새로 변경할 아이디를 입력하세요 : ");
				inputString = sc.nextLine();
				mem.setUserId(inputString);
				System.out.println(inputString + "으로 아이디 변경이 완료되었습니다. ");
				break;
			case 2:
				while (true) {
					System.out.print("새로 변경할 비밀번호를 입력하세요 : ");
					inputString = sc.nextLine();
					System.out.print("다시 한번 입력하세요 : ");
					againString = sc.nextLine();
					if (inputString.equals(againString)) {
						mem.setPassword(inputString);
						System.out.println(inputString + "으로 비밀번호 변경이 완료되었습니다. ");
						break;
					} else {
						System.out.println("비밀번호가 서로 다릅니다. 다시 입력해주세요");
						continue;
					}
				}
				break;
			case 3:
				System.out.print("새로 변경할 이름을 입력하세요 : ");
				inputString = sc.nextLine();
				mem.setName(inputString);
				System.out.println(inputString + "으로 이름 변경이 완료되었습니다. ");
				break;
			case 4:
				System.out.print("새로 변경할 이메일을 입력하세요 : ");
				inputString = sc.nextLine();
				mem.setEmail(inputString);
				System.out.println(inputString + "으로 이메일 변경이 완료되었습니다. ");
				break;
			case 5:
				System.out.print("새로 변경할 연락처를 입력하세요(010-xxxx-xxxx) : ");
				inputString = sc.nextLine();
				mem.setPhoneNum(inputString);
				System.out.println(inputString + "으로 연락처 변경이 완료되었습니다. ");
				break;
			case 6:
				infoUpdate();
				break Loop1;
			default:
				System.out.println("잘못된 값을 입력하셨습니다. 다시 입력하세요.");
				continue;
			}
		}
	}

	public void userMemberDelete() { // 회원탈퇴
		String inputString;
		String againString;

		Loop: while (true) {
			int cnt = 0;
			System.out.print("정말 탈퇴하시겠습니까? (y/n) : ");
			String s = sc.nextLine();
			if (s.equals("y") || s.equals("Y")) {
				System.out.print("비밀번호를 입력하세요 : ");
				inputString = sc.nextLine();
				System.out.print("다시 한번 비밀번호를 입력하세요 : ");
				againString = sc.nextLine();
				// inputString == 사용자비번 && againString == 사용자비번 수정해야함 !
				if (inputString.equals(mem.getPassword()) && againString.equals(mem.getPassword())) {

					for (int i = 0; i < memberList.size(); i++) {

						if (mem.getUserId() == memberList.get(i).getUserId()) {
							memberList.remove(i);
							mem = null;
							System.out.println("그동안 저희 서비스를 이용해주셔서 감사합니다.");
							cnt = 1;
							infoUpdate();
							break Loop;
						}
					}
				}
			}
		}

	}
	/*
	 * ---------------------------------- user memberUtil ---------------------------------------------
	 */

	public void infoUpdate() { // text file 정보 갱신 메소드
		File file = new File("data/Member.txt");
		if (file.exists()) {
			file.delete();
		}
		try {
			if (!file.exists())
				file.createNewFile();
			FileWriter fw = new FileWriter("data/Member.txt", true);
			BufferedWriter bw = new BufferedWriter(fw);

			for (int i = 0; i < memberList.size(); i++) {

				String line = memberList.get(i).getUserId() + "\t" + memberList.get(i).getPassword() + "\t"
						+ memberList.get(i).getName() + "\t" + memberList.get(i).getEmail() + "\t"
						+ memberList.get(i).getPhoneNum() + "\t" + Integer.toString(memberList.get(i).getBorrowCnt());

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
