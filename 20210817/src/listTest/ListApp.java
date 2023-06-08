package listTest;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ListApp {

	public static void main(String[] args) {

		ArrayList<String> list = new ArrayList<String>();
		// 추가
		list.add("사과");
		list.add("포도");
		list.add(0, "바나나");
		System.out.println(list);

		// 단건조회
		System.out.println("1번" + list.get(1));

		// 전체조회
		for (int i = 0; i < list.size(); i++) {
			System.out.println(String.format("%d번 %s", i, list.get(i)));
		}
		// 향상된 for문
		for (String temp : list) {
			System.out.println(temp);
		}

		// 검색
		int idx = list.indexOf("키위");
		System.out.println(idx == -1 ? "no" : idx + "번째");

		// 변경
		list.set(0, "메론");
		System.out.println(list);

		// 정렬
		// 삭제
		list.remove(0);
		System.out.println(list);
		list.clear();
		System.out.println(list);

		SimpleDateFormat sdf = new SimpleDateFormat();
		
		System.out.println(sdf.format(new Date()));

	}

}
