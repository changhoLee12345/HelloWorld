package co.yedam.phonebook;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

class User {
	String id;
	String pw;

	User(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}
}

public class UserCheck {
	HashSet<User> userList = new HashSet<>();

	public UserCheck() {
		readFromFile();
	}

	private void readFromFile() {
		File file = new File("C:/temp/userList.txt");
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String str = null;
			while ((str = br.readLine()) != null) {
				String[] record = str.split(" ");
				userList.add(new User(record[0], record[1]));
			}
			br.close();
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public boolean loginCheck(String id, String pass) {
		for (User user : userList) {
			if (user.id.equals(id) && user.pw.equals(pass)) {
				return true;
			}
		}
		return false;
	}
}
