package co.edu.app;

public class AccountApp {

	Account[] accounts = new Account[100]; // 계좌정보를 저장하기 위한 배열.

	public void execute() {

		while (true) {
			System.out.println("1.계좌생성 2.계좌목록 3.입금 4.출금 5.종료");
			System.out.print("선택>> ");

			int menu = 0;

			if (menu == 1) {
				createAccount();
			} else if (menu == 2) {
				accountList();
			} else if (menu == 3) {
				deposit();
			} else if (menu == 4) {
				withdraw();
			} else if (menu == 5) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
		}
		System.out.println("end of prog.");
	}

	// 계좌생성 시 실행 메소드.
	public void createAccount() {

	}

	// 입금처리 시 실행 메소드.
	public void deposit() {

	}

	// 출금처리 시 실행 메소드.
	public void withdraw() {

	}

	// 전체목록 실행 메소드.
	public void accountList() {

	}

}
