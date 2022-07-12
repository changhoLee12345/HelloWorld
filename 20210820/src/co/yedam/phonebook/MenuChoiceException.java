package co.yedam.phonebook;

public class MenuChoiceException extends Exception {
	int wrongChoice;

	public MenuChoiceException(int choice) {
		super("없는 메뉴번호입니다.");
		wrongChoice = choice;
	}

	public void showWrongChoice() {
		System.out.println(wrongChoice + "는 없는 메뉴번호입니다.");
	}
}
