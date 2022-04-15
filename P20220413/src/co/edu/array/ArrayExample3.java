package co.edu.array;

public class ArrayExample3 {
	public static void main(String[] args) {
		int[] intAry = { 78, 83, 88, 92, 63, 44, 55 };
		System.out.println(intAry.length);
		// 합을 구하는 코드. sum 선언.
		// double avg 평균.
		int sum = 0;
		int cnt = 0;
		double avg = 0;
		for (int i = 0; i < intAry.length; i++) {
			if (intAry[i] % 2 == 0) {
				sum += intAry[i];
				cnt++;
			}
		}
		avg = 1.0 * sum / cnt;
		System.out.println("합계 : " + sum);
		System.out.println("평균 : " + avg);
	}
}
