package co.yedam.collect;

import java.util.HashSet;
import java.util.Set;
import co.yedam.app.Emp;

public class EmpSetTest {
	public static void main(String[] args) {

		Set<Emp> set = new HashSet<>();

		// 추가 3건
		set.add(new Emp(100, "홍길동", "인사"));
		set.add(new Emp(101, "김기자", "인사"));
		set.add(new Emp(102, "이순신", "인사"));
		set.add(new Emp(100, "홍길동", "인사"));

		// 삭제
		set.remove(new Emp(101, "김기자", "총무"));

		// 이름만 출력
		for (Emp temp : set) {
			System.out.println(temp.getName());
		}

	}
}
