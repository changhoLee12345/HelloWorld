package co.yedam.emp;

import java.util.Scanner;

public class EmployeeList {
	// 싱글톤
	static EmployeeList instance = new EmployeeList();

	public static EmployeeList getInstance() {
		return instance;
	}

	Employee[] list; // 사원 배열
	int empNum; // 사원수
	Scanner scanner = new Scanner(System.in);

	private EmployeeList() {
	}

	// list초기화
	private EmployeeList(Employee[] list) {
		this.list = list;
		this.empNum = list.length;
	}

	// 배열객체 선언
	// public > default > private
	// 모두 같은패키지 자신 클래스 안
	public void init() {
		System.out.print("사원수 입력>");
		int num = scanner.nextInt();
		list = new Employee[num];
	}

	// 사원정보 입력 -> 배열에 추가
	public void input() {
		if (empNum >= list.length) {
			System.out.println("입력초과");
			return;
		}
		System.out.printf("%d 사번>", empNum);
		int no = scanner.nextInt();

		System.out.print("이름>");
		String name = scanner.next();

		System.out.print("급여>");
		int sal = scanner.nextInt();

		list[empNum++] = new Employee(no, name, sal);
	}

	// 사번에 해당하는 이름을 조회
	public String search(int employeeId) {
		String name = "";

		for (int i = 0; i < empNum; i++) {
			if (employeeId == list[i].getEmployeeId()) {
				name = list[i].getName();
				break;
			}
		}
		return name;
	}

	// 전체출력
	public void print() {
		for (int i = 0; i < empNum; i++) {
			System.out.printf("%5d %10s %7d\n", list[i].getEmployeeId(), list[i].getName(), list[i].getSalary());
		}
	}

	// 급여합계
	public int sum() {
		int total = 0;
		for (int i = 0; i < empNum; i++) {
			total += list[i].getSalary();
		}
		return total;
	}
}
