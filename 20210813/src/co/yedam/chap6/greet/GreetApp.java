package co.yedam.chap6.greet;

public class GreetApp {

	public static void main(String[] args) {
		//Greet 객체 생성
		Greet greet = new Greet("이순신");		
		//인사말 출력
		greet.printGreet();
		
		Greet greet1 = new Greet("김유신");		
		greet1.printGreet();
		
		Greet greet2 = new Greet();		
		greet2.printGreet();
	}
}
