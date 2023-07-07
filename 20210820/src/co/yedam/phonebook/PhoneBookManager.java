package co.yedam.phonebook;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.Iterator;

public class PhoneBookManager {
	private String runType = "stream";// "file";

	private File dataFile = new File("/home/linuxie/Dev/phonebook.dat");

	HashSet<PhoneInfo> infoStorage = new HashSet<PhoneInfo>();

	static PhoneBookManager inststance = null;

	public static PhoneBookManager getInstance() {
		if (inststance == null)
			inststance = new PhoneBookManager();

		return inststance;
	}

	private PhoneBookManager() {
		readFromFile();
	}

	private PhoneInfo readFriendInfo() {
		System.out.print("이름>");
		String name = MenuViewer.keyboard.nextLine();
		System.out.print("전화번호>");
		String phone = MenuViewer.keyboard.nextLine();
		return new PhoneInfo(name, phone);
	}

	private PhoneInfo readUnivFriendInfo() {
		System.out.print("이름>");
		String name = MenuViewer.keyboard.nextLine();
		System.out.print("전화번호>");
		String phone = MenuViewer.keyboard.nextLine();
		System.out.print("전공>");
		String major = MenuViewer.keyboard.nextLine();
		System.out.print("학년>");
		int year = MenuViewer.keyboard.nextInt();
		MenuViewer.keyboard.nextLine();
		return new PhoneUnivInfo(name, phone, major, year);
	}

	private PhoneInfo readCompanyFriendInfo() {
		System.out.print("이름>");
		String name = MenuViewer.keyboard.nextLine();
		System.out.print("전화번호>");
		String phone = MenuViewer.keyboard.nextLine();
		System.out.print("회사명>");
		String company = MenuViewer.keyboard.nextLine();
		return new PhoneCompanyInfo(name, phone, company);
	}

	public void inputData() throws MenuChoiceException {
		System.out.println("전화번호 구분");
		System.out.println("1. 일반, 2. 대학, 3. 회사");
		System.out.print("선택> ");
		int choice = MenuViewer.keyboard.nextInt();
		MenuViewer.keyboard.nextLine();
		PhoneInfo info = null;

		if (choice < INPUT_SELECT.NORMAL || choice > INPUT_SELECT.COMPANY)
			throw new MenuChoiceException(choice);

		switch (choice) {
		case INPUT_SELECT.NORMAL:
			info = readFriendInfo();
			break;
		case INPUT_SELECT.UNIV:
			info = readUnivFriendInfo();
			break;
		case INPUT_SELECT.COMPANY:
			info = readCompanyFriendInfo();
			break;
		}

		boolean isAdded = infoStorage.add(info);

		if (isAdded == true)
			System.out.println("등록완료 \n");
		else
			System.out.println("등록오류 \n");
	}

	public void searchData() {
		System.out.print("이름>");
		String name = MenuViewer.keyboard.nextLine();

		PhoneInfo info = search(name);
		if (info == null) {
			System.out.println("찾는 이름이 없습니다. \n");
		} else {
			info.showPhoneInfo();
		}
	}

	public void deleteData() {
		System.out.print("이름>");
		String name = MenuViewer.keyboard.nextLine();

		Iterator<PhoneInfo> itr = infoStorage.iterator();
		while (itr.hasNext()) {
			PhoneInfo curInfo = itr.next();
			if (name.compareTo(curInfo.name) == 0) {
				itr.remove();
				System.out.println("삭제완료. \n");
				return;
			}
		}

		System.out.println("삭제할 이름이 없습니다. \n");
	}

	private PhoneInfo search(String name) {
		Iterator<PhoneInfo> itr = infoStorage.iterator();
		while (itr.hasNext()) {
			PhoneInfo curInfo = itr.next();
			if (name.compareTo(curInfo.name) == 0) // -1 0 1 'd' - 'b' => 2
				return curInfo;
		}
		return null;
	}

	public void storeToFile() {
		if (runType.equals("stream")) {
			storeToStream();
		} else {
			try {

//			2.FileWriter 저장.
				FileWriter out = new FileWriter(dataFile);
				Iterator<PhoneInfo> itr = infoStorage.iterator();
				while (itr.hasNext()) {
					out.write(itr.next().toString());
				}
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void storeToStream() {
		try {
//		1.Object 저장.
			FileOutputStream fos = new FileOutputStream(dataFile);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			// 바로 지정.
//			oos.writeObject(infoStorage);
			Iterator<PhoneInfo> itr = infoStorage.iterator();
			while (itr.hasNext()) {
				oos.writeObject(itr.next());
			}
			oos.close();
			fos.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void readFromStream() {
//		1.Object 읽기.
		try {
			FileInputStream fis = new FileInputStream(dataFile);
			ObjectInputStream ois = new ObjectInputStream(fis);
			// 1. SetCollection에 바로 지정.
//			infoStorage = (HashSet<PhoneInfo>) ois.readObject();
			// 2. PhoneInfo 에 지정.
			while (true) {
				try {
					PhoneInfo info = (PhoneInfo) ois.readObject();
					infoStorage.add(info);
				} catch (Exception e) {
					break;
				}
			}
			ois.close();
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void readFromFile() {
		if (dataFile.exists() == false)
			return;

		if (runType.equals("stream")) {
			readFromStream();
		} else {
			try {

//			2.FileReader 읽기.
				FileReader reader = new FileReader(dataFile);// reader.read()
				BufferedReader in = new BufferedReader(reader);
				String string;
				PhoneInfo info = null;
				while ((string = in.readLine()) != null) {
					String[] record = string.split(",");
					int gbn = Integer.parseInt(record[0]);
					switch (gbn) {
					case INPUT_SELECT.NORMAL:
						info = new PhoneInfo(record[1], record[2]);
						break;
					case INPUT_SELECT.UNIV:
						info = new PhoneUnivInfo(record[1], record[2], record[3], Integer.parseInt(record[4]));
						break;
					case INPUT_SELECT.COMPANY:
						info = new PhoneCompanyInfo(record[1], record[2], record[3]);
						break;
					}

					infoStorage.add(info);
					System.out.println(string);
				}
				in.close();
			} catch (IOException e) {
				return;
			}
		}
	}
}
