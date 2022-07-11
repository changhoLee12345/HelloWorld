package co.yedam.emp;

//인터페이스 : 상수 + 추상메서드  
//상속(부모)
//개발표준 -> 객체 교체가가능
public interface EmployeeList {

	public static final String name = "aaa";

	// 배열객체 선언
	void init();

	// 사원정보 입력 -> 배열에 추가
	void input();

	// 사번에 해당하는 이름을 조회
	String search(int employeeId);

	// 전체출력
	void print();

	// 급여합계
	int sum();
}