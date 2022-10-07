package co.yedam.collect;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class WordAry {
	public static ArrayList<String> randomWords() throws FileNotFoundException {
		String file = "src/co/yedam/collect/wordAry.txt";
		File wordFile = new File(file);

		ArrayList<String> words = new ArrayList<>();

		Scanner scn = new Scanner(wordFile);

		// ArrayList에 문장을 담아서 랜덤하게 가져오도록 한다.
		while (scn.hasNext()) {
			String readStr = scn.nextLine();
			readStr = readStr.replaceAll("\"", "").trim();
//			System.out.println(readStr.substring(0, readStr.indexOf(",")));
//			System.out.println(readStr);
			words.add(readStr.substring(0, readStr.indexOf(",")));

		}

		Set<Integer> set = new HashSet<>();
		while (set.size() < 5) {
			set.add((int) (Math.random() * words.size()));
		}
		ArrayList<String> randomWords = new ArrayList<>();
		for (int no : set) {
			randomWords.add(words.get(no));
		}

		scn.close();
		return randomWords;
	}

	public static void timeShow(long duration) {
		long min = duration / (60 * 1000);
		long sec = duration % (60 * 1000) / 1000;

		System.out.printf("%d 분 %d초\n", min, sec);
	}

	public static void main(String[] args) throws FileNotFoundException {

		ArrayList<String> words = randomWords(); // 새로운 10개의 문장 생성.
		Scanner scn = new Scanner(System.in);

		long start = System.currentTimeMillis();

		// 문장을 하나씩 제거하기.
		while (true) {
			// 문장출력.
			for (String word : words) {
				System.out.println(word);
			}

			System.out.print(">> ");
			String searchWord = scn.nextLine();
			for (int i = 0; i < words.size(); i++) {
				if (words.get(i).equals(searchWord)) {
					words.remove(i);
					break;
				}
			}
			if (words.isEmpty()) {
				break;
			}
		}
		scn.close();
		long end = System.currentTimeMillis();

		timeShow(end - start);
		System.out.println("end of file.");
	}
}
