package co.yedam.mavenProject.jdbc;

import co.yedam.mavenProject.jdbc.member.MemberControl;

public class ManageExe {
	public static void exe() {
		int menu = -1;
		boolean run = true;
		MemberControl mcontrol = MemberControl.getInstance();

		while (run) {
			menu = Utils.inputMenu("1.로그인 2.회원가입 3.종료");

			switch (menu) {
			case 1: // 로그인
				mcontrol.loginCheck();
				break;
			case 2: // 회원가입
				mcontrol.addMember();
				break;
			case 3: // 종료
				System.out.println("프로그램을 종료합니다.");
				run = false;
			}

		}
		System.out.println("end of prog.");
	}
}
