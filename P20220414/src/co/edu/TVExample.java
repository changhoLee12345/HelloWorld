package co.edu;

public class TVExample {
	public static void main(String[] args) {
		int num = 10;
		String str = "Hello";

		Television tv = new Television(); //
		tv.company = "삼성";
		tv.color = "검은색";
		tv.price = 300000;
		tv.model = "30Inch";
		tv.turnOn();
		tv.changeChanel(10);
		tv.turnOff();

		Television tv1 = new Television(); //
		tv1.company = "삼성";
		tv1.color = "검은색";
		tv1.price = 300000;
		tv1.model = "30Inch";

		System.out.println(tv == tv1);
		System.out.println(tv);
		System.out.println(tv1);

		Student stud1 = new Student();
		stud1.name = "홍길동";
		stud1.studNo = "22-1234567";
		stud1.age = 20;
		stud1.height = 174.5;

		Student stud2 = new Student();
		stud2.name = "우영원";
		stud2.studNo = "22-323456";
		stud2.age = 24;
		stud2.height = 165.3;

		Student stud3 = new Student("황하경", "22-876456");
		stud3.age = 25;
		stud3.height = 163.5;

		Student stud4 = new Student("김민서", "22-232323", 23);
		stud4.height = 168.3;

		stud1.study();
		stud2.study();

		stud4.showInfo();

	}
}
