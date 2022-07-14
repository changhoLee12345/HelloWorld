package co.yedam.chap6.insa;
// 클래스 = 필드 + 메서드

//메서드 
//1. data 처리 (합계계산, 출력)
//2. 반복되는 코드를 메서드 선언
//메서드 오버로딩 : 같은이름의 메서드 여러개 선언. 매개변수의 타입, 갯수는 달라야함.
public class LinePrint {
	void print(){		
		System.out.println("===========================");
	}
	
	void print(int cnt){	
		for(int i=0; i<cnt; i++) {
			System.out.print("=");
		}
		System.out.println();
	}  
	
	void print(int cnt, String s){	
		for(int i=0; i<cnt; i++) {
			System.out.print(s);
		}
		System.out.println();
	}
}
