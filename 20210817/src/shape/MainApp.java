package shape;
public class MainApp {
	public static void main(String[] args) {

		//부모타입의 참조변수는 자식객체를 참조할수 있다
		Shape s = new Circle();
		s.draw();  //참조대상의 오버라이딩한 메서드를 호출
		
		s = new Tri();
		s.draw();  //실행코드는 같아도 실행결과는 다름(다형성)
		
		Circle c1 = new Circle();
		c1.getR();
		
		Shape s1;
		s1 = c1;   //자식을 부모에 저장할때는 자동형변환
		s1.draw(); //다형성 (참조대상=자식객체)의 오버라이딩 메서드 호출
		((Circle)s1).getR();
		
		//추상클래스는 객체로 생성불가
		Shape s2 = new Shape();
		s2.draw();
		((Circle)s2).getR();
	}
}
