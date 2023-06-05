package co.yedam.chap6.insa;

public class Departments {
	int departmentId; // 부서번호
	String departmentName;// 부서명
	int managerId;// 메니저
	int locationId;// 지역

	// 생성자 오버로딩
	// 기본생성자
	Departments() {
	}

	// 부서명 초기화
	Departments(String departmentName) {
		this.departmentName = departmentName;
	}

	// 부서번호, 부서명 초기화
	Departments(int departmentId, String departmentName) {
		this.departmentId = departmentId;
		this.departmentName = departmentName;
	}

	// 필드 4개 초기화
	public Departments(int departmentId, String departmentName, int managerId, int locationId) {
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.managerId = managerId;
		this.locationId = locationId;
	}

	@Override
	public String toString() {
		return "Departments [departmentId=" + departmentId + ", departmentName=" + departmentName + ", managerId="
				+ managerId + ", locationId=" + locationId + "]";
	}

}
