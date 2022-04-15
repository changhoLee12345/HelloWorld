package co.edu;
// 객체 -> 도면 -> 텔레비젼(삼성,엘지)
// Object -> Class -> Instance.
// 추상화(텔레비젼의 모든 속성 -> 필요한 부분)
public class Television {
	// 속성. -> 필드
	String company;
	String model;
	int price;
	String color;
	
	// 기능. -> 메소드(반환유형, 메소드명, 매개변수)
	void turnOn() {
		System.out.println("텔레비젼을 켭니다.");
	}
	
	void turnOff(){
		System.out.println("텔레비젼을 끕니다.");
	}
	
	void changeChanel(int chanel){
		System.out.println(chanel + "번 채널로 로 변경합니다.");
	}
}
