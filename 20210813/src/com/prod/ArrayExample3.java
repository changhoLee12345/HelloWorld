package com.prod;

public class ArrayExample3 {
	public static void main(String[] args) {
		String[] names = new String[5];
		names[0] = "홍길동";
		names[1] = "234";
		names[2] = "조수연";
		names[3] = "황진주";

		names[1] = "이삼사";
		names[4] = "이창호";
		names[0] = null;

		String searchName = "황진주";

		for (int i = 0; i < 5; i++) {
//			if (names[i] != null) {
//				System.out.println("이름: " + names[i]);
//			}
			if (names[i] != null && names[i].equals(searchName)) {
				System.out.println(i + 1 + "번째 위치에 있습니다.");
			}
		}
	}
}
