package co.yedam;

import java.util.Scanner;

/*
 * 문제2 : 정수형 변수 num1, num2를 선언하고  Scanner 클래스를 이용하여 사용자의 입력값을 비교한 후 큰 수에서 작은 수를 나눈 결과값을
 * 소수점 첫번째 자리까지 구하는 기능을 구현하세요.
 * 출력 예: 15를 7로 나누면 14.1 입니다.
 */
public class Exam02 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int num;
		
		float result=0;
		int num1 = scn.nextInt();
		
		int num2 = scn.nextInt();
		if(num1 > num2) {
			System.out.printf("%d을 %d로 나누면 %.1f 입니다.",num1,num2,result);
			result = num1%num2;}
		else if(num1<num2) {
			System.out.printf("%d을 %d로 나누면 %.1f 입니다.",num2,num1,result);
			result = num1%num2;
		}
	}
}
