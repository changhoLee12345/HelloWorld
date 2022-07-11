package shape;

public class Circle 
      extends Shape implements Drawable, Movable{
	private int r;

	public Circle(){}
	
	public Circle(String color) {
		setColor(color);
	}
	public int getR() {
		return r;
	}
	public void setR(int r) {
		this.r = r;
	}

	@Override
	public void draw() {
		System.out.println("원 그리기");
	}

	@Override
	public void move() {
		System.out.println("원 이동");
	}
}
