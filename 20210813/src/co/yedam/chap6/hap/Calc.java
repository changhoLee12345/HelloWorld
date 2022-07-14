package co.yedam.chap6.hap;
public class Calc {
	int num1;
	int num2;	
	//두수 초기화
	public Calc(int num1, int num2) {
		this.num1 = num1;
		this.num2 = num2;
	}	
	//합계
	public int add() {
		return num1+num2;
	}	
	//뺄셈
	public int sub() {
		return num1-num2;
	}
	//곱셈
	public int mul() {
		return num1*num2;
	}
	//나눗셈
	public double div() {
		return (double)num1/num2;
	}
}
