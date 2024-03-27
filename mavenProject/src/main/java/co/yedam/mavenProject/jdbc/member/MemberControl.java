package co.yedam.mavenProject.jdbc.member;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import co.yedam.mavenProject.jdbc.Utils;
import co.yedam.mavenProject.jdbc.swim.SwimControl;
import co.yedam.mavenProject.jdbc.swim.SwimDAO;

public class MemberControl {
	public static MemberControl instance = new MemberControl();

	private MemberControl() {
	}

	public static MemberControl getInstance() {
		if (instance == null) {
			instance = new MemberControl();
		}
		return instance;
	}

	private MemberDAO dao = MemberDAO.getInstance();
	private MemberVO loginVO = null;
	

	// loginCheck(일반사용자: 강의요청, 관리자: 강좌등록)
	public void loginCheck() {
		String id = Utils.inputString("아이디를 입력");
		String pw = Utils.inputString("비번을 입력");
		MemberVO mvo = dao.loginCheck(id, pw);
		
		if (mvo == null) {
			System.out.println("아이디와 비번을 확인하세요.");
			return;
		}
		loginVO = mvo;

		showMenu(mvo); // 메뉴출력.
	}

	public void showMenu(MemberVO mvo) {
		String auth = dao.checkResponsibility(mvo);
		if (auth == null) {
			System.out.println("권한없음");
			return;
		}
		if (auth.equals("USER")) {
			userMenu();
		} else if (auth.equals("ADMIN")) {
			adminMenu();
		}
	}

	void userMenu() {
		boolean run = true;
		while (run) {
			int menu = Utils.inputMenu("1.수강신청 2.수강목록 3.상위메뉴");
			switch (menu) {
			case 1: // 수강신청.
				System.out.println("수강신청 합니다.");
				break;
			case 2: // 수강목록.
				lectureList(loginVO.getMemId());
				break;
			case 3: // 상위메뉴.
				System.out.println("상위메뉴로 이동합니다.");
				return;
			}
		}
	}
	
	void lectureList(String id) {
		System.out.println("수강목록 입니다.");
		dao.getLectureList(id).forEach(lecture -> {
			System.out.println(lecture.toString());
		});
	}

	void adminMenu() {
		addMemberAuth(); // 아래...신규회원등록...
		SwimControl.getInstance().exe();
	}

	void addMemberAuth() {
		List<MemberVO> mems = dao.checkMemberAuth();
		if (mems.size() > 0) {
			// 신규멤머 목록보여주기.
			mems.forEach(member -> {
				System.out.println(member.toString());
			});

			int menu = Utils.inputMenu("1.추가 2.종료");
			switch (menu) {
			case 1:// add.
				String ids = Utils.inputString("id>> user01 user02");
				List<String> names = Arrays.asList(ids.split(" "));
				addAuthorities(names);

			case 2:// end.
				System.out.println("권한추가종료.");
			}
		}
	}

	void addAuthorities(List<String> names) {
		names.forEach(name -> {
			dao.insertAuth(name);
		});
		System.out.println("권한등록완료.");
	}

	public void addMember() {
		String id = Utils.inputString("아이디를 입력");
		String pw = Utils.inputString("비번을 입력");
		String ph = Utils.inputString("전번을 입력");
		String nm = Utils.inputString("이름을 입력");

		MemberVO mvo = new MemberVO();
		mvo.setMemId(id);
		mvo.setMemPw(pw);
		mvo.setMemPhone(ph);
		mvo.setMemName(nm);

		if (dao.insertMember(mvo)) {
			System.out.println("등록 성공.");
		} else {
			System.out.println("등록 실패.");
		}

	} // end of addMember.

}
