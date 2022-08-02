package com.edu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MemberApp {

	List<Member> members = new ArrayList<Member>();
	Scanner scn = new Scanner(System.in);

	public MemberApp() {
	}

	// MemberService 를 구현하는 구현클래스를 선언.
	// inner클래스.
	class MemberServiceImpl implements MemberService {

		@Override
		public void addMember(Member member) {
			members.add(member);
		}

		@Override
		public void modifyMember(Member member) {
			for (Member mbr : members) {
				if (mbr.getMemberId() == member.getMemberId()) {
					mbr.setPhone(member.getPhone());
				}
			}
		}

		@Override
		public List<Member> memberList() {
			return members;
		}

	}

	public void execute() {
		// 메뉴: 1.등록 2.수정 3.전체리스트 9.종료
		// 1)도서반=>기본정보+도서반장,강의실이름
		// 축구반=>기본정보+코치이름,락커룸이름
		// 수영반=>기본정보+강사이름,수영등급
		MemberService service = new MemberServiceImpl();

		while (true) {
			int menu = 0;
			System.out.println("1.등록 2.수정 3.전체리스트 9.종료");
			System.out.println("선택>>");
			// 예외처리.
			try {
				menu = scn.nextInt(); // a 엔터.
			} catch (Exception e) {
				System.out.println("값을 잘못.");
			}

			if (menu == 1) {
				System.out.println("1.도서회원 2.축구회원 3.수영회원");
				int menu2 = scn.nextInt();

				// 공통질문..
				System.out.println("회원아이디 입력>>> ");
				int memberId = scn.nextInt();
				System.out.println("회원이름 입력>>> ");
				String membName = scn.next();
				System.out.println("연락처 입력>>> ");
				String phone = scn.next();

				if (menu2 == 1) {
					System.out.println("반장이름을 입력>>> ");
					String banName = scn.next();
					System.out.println("강의실을 입력>>> ");
					String roomName = scn.next();
					BookMember mem = //
							new BookMember(memberId, membName, phone, banName, roomName);
					service.addMember(mem); // 부모>자식

				} else if (menu2 == 2) {
					System.out.println("코치이름을 입력>>> ");
					String banName = scn.next();
					System.out.println("라커룸을 입력>>> ");
					String roomName = scn.next();
					SoccerMember mem = //
							new SoccerMember(memberId, membName, phone, banName, roomName);
					service.addMember(mem); // 부모>자식

				} else if (menu2 == 3) {
					System.out.println("강사이름을 입력>>> ");
					String banName = scn.next();
					System.out.println("등급을 입력>>> ");
					String roomName = scn.next();
					SwimMember mem = //
							new SwimMember(memberId, membName, phone, banName, roomName);
					service.addMember(mem); // 부모>자식

				} else {
					System.out.println("잘못된 회원메뉴를 선택했습니다.");
				}

			} else if (menu == 2) {

			} else if (menu == 3) {
				List<Member> list = service.memberList();
				for (Member mem : list) {
					System.out.println(mem.toString());
				}

			} else if (menu == 9) {
				System.out.println("프로그램을 종료합니다.");
				break;
			} else {
				System.out.println("잘못된 메뉴를 선택했습니다.");
			}
		}
		System.out.println("end of program");

	} // end of execute()
} // end of class
