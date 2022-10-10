package co.yedam.memo.except;

public class ExitException extends Exception {

	public ExitException() {
		System.out.println("프로그램을 종료합니다.");
	}
}
