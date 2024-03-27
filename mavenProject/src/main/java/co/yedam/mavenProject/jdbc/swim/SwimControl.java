package co.yedam.mavenProject.jdbc.swim;

import co.yedam.mavenProject.jdbc.Utils;

public class SwimControl {

	private static SwimControl instance = new SwimControl();

	private SwimControl() {

	}

	public static SwimControl getInstance() {
		return instance;
	}

	private SwimDAO sdao = SwimDAO.getInstance();

	public void exe() {
		boolean run = true;
		while (run) {
			int menu = Utils.inputMenu("1.강좌등록 2.강좌목록 3.상위메뉴");
			switch (menu) {
			case 1: // 강좌등록.
				addSwimclass();
				break;
			case 2: // 강좌목록.
				listSwim();
				break;
			case 3: // 상위메뉴.
				System.out.println("상위메뉴로 이동합니다.");
				return;
			}
		}
	}

	private void addSwimclass() {
		System.out.println("강좌등록 합니다.");
	}

	private void listSwim() {
		System.out.println("강좌목록 입니다.");
		sdao.swimList().forEach(swim -> {
			System.out.println(swim.toString());
		});

	}
}
