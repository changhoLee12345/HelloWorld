package homework;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Lotto {

	public static void main(String[] args) {

		// 숫자 6개를 생성 - 중복값 안됨
		int cnt = 6;

		List<Integer> list = new ArrayList<>();

		while (list.size() < cnt) {
			// 난수
			int r = (int) (Math.random() * 10) + 1; // 난수 1~10

			if (list.contains(r)) {
				continue;
			}

			list.add(r);
		}

		// iterator 이용해서 전체출력
		Iterator<Integer> iter = list.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
	}

}
