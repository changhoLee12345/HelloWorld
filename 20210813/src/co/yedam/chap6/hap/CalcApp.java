package co.yedam.chap6.hap;

public class CalcApp {

	public static void main(String[] args) {
		Calc calc = new Calc(10,20);
		
		System.out.println(  calc.add() );
		
		int subResult = calc.sub();
		System.out.println(subResult);	
		
		System.out.println(calc.mul());
		
		System.out.println(calc.div());
	}

}
