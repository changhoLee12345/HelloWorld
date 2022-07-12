package co.yedam.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ObjectTest {

	public static void main(String[] args) {
		// write1();
		read1();
	}

	public static void read1() {
		try {
			FileInputStream fis = new FileInputStream("c:/Temp/emp.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			ArrayList<Emp> list = (ArrayList<Emp>) ois.readObject();
			System.out.println(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void write1() {
		ArrayList<Emp> list = new ArrayList<>();
		list.add(new Emp(1, "홍길동", "인사"));
		list.add(new Emp(2, "김길동", "개발"));
		list.add(new Emp(3, "이기자", "인사"));

		try {
			FileOutputStream fos = new FileOutputStream("c:/Temp/emp.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(list);
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
