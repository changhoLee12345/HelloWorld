package file.io;

import java.io.BufferedReader;
import java.io.FileReader;

class Student {
	private int studNo;
	private String name;
	private int age;
	private int engScore;
	private int mathScore;
	private int korScore;

	public Student(int studNo, String name, int age, int engScore, int mathScore, int korScore) {
		super();
		this.studNo = studNo;
		this.name = name;
		this.age = age;
		this.engScore = engScore;
		this.mathScore = mathScore;
		this.korScore = korScore;
	}

	public int getStudNo() {
		return studNo;
	}

	public void setStudNo(int studNo) {
		this.studNo = studNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getEngScore() {
		return engScore;
	}

	public void setEngScore(int engScore) {
		this.engScore = engScore;
	}

	public int getMathScore() {
		return mathScore;
	}

	public void setMathScore(int mathScore) {
		this.mathScore = mathScore;
	}

	public int getKorScore() {
		return korScore;
	}

	public void setKorScore(int korScore) {
		this.korScore = korScore;
	}

}

public class FileIOExample {
	public static void main(String[] args) throws Exception {
		FileReader fr = new FileReader("src/file/io/students.txt");
		BufferedReader br = new BufferedReader(fr);
		String studInfo = "";
		while (true) {
			studInfo = br.readLine();
			if (studInfo == null) {
				break;
			}
			System.out.println(studInfo);
		}
		System.out.println("end of prog.");
	}
}
