package co.yedam.emp;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeArrayList implements EmployeeList {

	// 싱글톤
	static EmployeeArrayList instance = new EmployeeArrayList();

	public static EmployeeArrayList getInstance() {
		return instance;
	}

	ArrayList<Employee> list;
	Scanner scanner = new Scanner(System.in);

	@Override
	public void init() {
		list = new ArrayList<Employee>();
	}

	@Override
	public void input() {
		System.out.printf("%d 사번>", list.size());
		int no = scanner.nextInt();

		System.out.print("이름>");
		String name = scanner.next();

		System.out.print("급여>");
		int sal = scanner.nextInt();

		list.add(new Employee(no, name, sal));
	}

	@Override
	public String search(int employeeId) {
		String name = "";
		for (int i = 0; i < list.size(); i++) {
			if (employeeId == list.get(i).getEmployeeId()) {
				name = list.get(i).getName();
				break;
			}
		}
		return name;
	}

	@Override
	public void print() {
		for (int i = 0; i < list.size(); i++) {
			System.out.printf("%5d %10s %7d\n", list.get(i).getEmployeeId(), list.get(i).getName(),
					list.get(i).getSalary());
		}
	}

	@Override
	public int sum() {
		// TODO Auto-generated method stub
		return 0;
	}

}
