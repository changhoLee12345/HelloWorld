package co.edu.array;

public class ArrayExample {
	public static void main(String[] args) {
		// 학생의 점수 30명.
		int score1 = 80;
//		....
		int score30 = 78;

		// 여러개의 같은 유형의 값을 저장.
		int[] intAry = new int[30]; // 정수int 30개 담을 공간.

		intAry[0] = 30;
		intAry[4] = 40;
		intAry[29] = 55;
		
		System.out.println(intAry[0]);
		System.out.println(intAry[1]);
		
		double[] dblAry = new double[10]; // double 저장 10개 선언.
		
		String[] strAry = new String[5]; // 참조변수 => null.
		System.out.println(strAry[0]); 
		
		int[] otherAry = {10, 20, 30, 40}; // 초기값을 지정.
		int[] theOtherAry = {10, 20, 30, 40}; // 초기값을 지정.
		System.out.println(otherAry[0]);
		
		if(otherAry[0] == theOtherAry[0]) {
			System.out.println("same");
		} else {
			System.out.println("diff");
		}
	}
}
