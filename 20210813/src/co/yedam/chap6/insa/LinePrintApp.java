package co.yedam.chap6.insa;

public class LinePrintApp {

	public static void main(String[] args) {

		LinePrint linePrint = new LinePrint();
		linePrint.print();
		linePrint.print();

		linePrint.print(10);  //메서드 호출과 리턴
		linePrint.print(50);
		
		linePrint.print(30, "@");
	}

}
