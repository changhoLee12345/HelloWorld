package 다형성;

public class Circle extends Shape{
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
}
