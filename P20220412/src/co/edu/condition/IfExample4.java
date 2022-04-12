package co.edu.condition;

public class IfExample4 {
	public static void main(String[] args) {
		// 임의의 값을 생성해주는 Math.random().
		int randomVal = (int) (Math.random() * 100) + 1; // 반환값이 double 0 <= 값 < 1
		System.out.println(randomVal);
		
		// 생성된 값이 1 ~ 50 까지.
		// 생성된 값이 51 ~ 60 까지.
		// 61 ~ 70, 71 ~ 80, 81 ~ 90, 91 ~ 100 범위.
		System.out.println("생성된 값은 61 ~ 70까지 범위 값.");
	}
}
