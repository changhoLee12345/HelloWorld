package co.yedam.chap6.insa;

public class Employees {
	int employeeId; // 사원번호
	String firstName; // 사원명
	Departments dept; // 부서정보

	// 기본생성자
	Employees() {
	}

	// 사원번호, 사원명 초기화
	Employees(int employeeId, String firstName) {
		this.employeeId = employeeId;
		this.firstName = firstName;
	}

	// 사원번호, 사원명, 부서 초기화
	Employees(int employeeId, String firstName, Departments dept) {
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.dept = dept;
	}
}
