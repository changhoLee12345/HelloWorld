package co.edu.game;

public class Game {

	static final int MY_POS = 7;

	public void start() {

		game();

	}
	
	

	// 위치 변경하기 게임.
	public void game() {
		Pos[] pos = new Pos[MY_POS];
		for (int i = 0; i < MY_POS; i++) {
			int startPosition = (int) (Math.random() * MY_POS) + 3;
			pos[i] = new Pos(i, startPosition);
		}
		int[][] fields = new int[6][10];
		int curx = 0, cury = 0;

		for (int times = 0; times < 100; times++) {
			pos[MY_POS - 1] = new Pos(curx, cury);
			clear();
			System.out.println("________________________________________");
			for (int i = 0; i < fields.length; i++) {
				for (int j = 0; j < fields[i].length; j++) {
					boolean exist = false;
					for (int k = 0; k < pos.length - 1; k++) {
						if (i == pos[k].x && j == pos[k].y) {
							exist = true;
							// 위치변환.
							if (pos[k].y == 0) {
								int position = (int) (Math.random() * 6);
								pos[k] = new Pos(position, 9);
							} else {
								pos[k] = new Pos(pos[k].x, pos[k].y - 1);
							}

						}
					}
					if (pos[MY_POS - 1].x == i && pos[MY_POS - 1].y == j) {
						System.out.print("|==>");
					} else if (exist) {
						System.out.printf("|%s,%s", i, j);
						exist = false;
					} else {
						System.out.print("|___");
					}
				}
				System.out.println();
			}

			// 위치를 변경시키는 조건.
			for (int i = 0; i < pos.length - 1; i++) {
				if (pos[i].x == curx && pos[i].y == cury) {
					if (curx < 4)
						curx++;
					else
						curx--;
				}
			}

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("----------------------------------------");
		System.out.println("menu");
	}

	public void clear() {
		for (int i = 0; i < 10; i++)
			System.out.println();
	}
}
