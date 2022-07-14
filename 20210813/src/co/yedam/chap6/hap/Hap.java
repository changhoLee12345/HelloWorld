package co.yedam.chap6.hap;
/*
 * 두수의 합을 계산
 * data : int형 두개
 * 기능 :두 수의 합을 출력
 */
public class Hap {
	int num1 = 10;
	int num2 = 20;
	
	public int add() {
		int temp;
		temp = num1+num2;
		return temp;
	}
	
	public void print() {
		System.out.println(num1 + num2);
		return;
	}
}
