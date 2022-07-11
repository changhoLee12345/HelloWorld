package 다형성;

public class MainApp2 {

	public static void main(String[] args) {
		
		Shape s = new Circle();
		s.draw(); //다형성  : 상속받은 메서드 오버라이딩
		((Circle)s).getR();
		Circle c = new Circle("red");
		c.setR(10);
		print(c);
		Tri t = new Tri("blue");
		t.setEx(5);
		print(t);
	}
	public static void print(Shape c) {
		System.out.println(c.getColor() );
		c.draw();
		if( c instanceof Circle) {
			System.out.println(     ((Circle)c).getR()   );
		} else if(c instanceof Tri) {
			System.out.println(     ((Tri)c).getEx()   );
		}
	}

}
