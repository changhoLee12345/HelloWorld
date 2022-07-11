package 다형성;
/*
 * abstract : 반드시 오버라이딩 강제성
 * 추상클래스
 */
public abstract class Shape {
	private String color;
	private String line;
	private int sx;
	private int sy;	
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getLine() {
		return line;
	}
	public void setLine(String line) {
		this.line = line;
	}
	public int getSx() {
		return sx;
	}
	public void setSx(int sx) {
		this.sx = sx;
	}
	public int getSy() {
		return sy;
	}
	public void setSy(int sy) {
		this.sy = sy;
	}
	public abstract void draw() ;
}
