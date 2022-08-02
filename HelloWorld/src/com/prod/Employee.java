package com.prod;

public class Employee {
	// field.
	private int employeeId;
	private String employeeName;
	private String department;
	private String job;
	private int salary;

	// employeeId
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public int getEmployeeId() {
		return this.employeeId;
	}

	// employeeName
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeName() {
		return this.employeeName;
	}

	// department
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	// job
	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	// salary
	public void setSalary(int salary) {
		if (salary < 0) {
			this.salary = 100000;
		} else {
			this.salary = salary;
		}
	}

	public int getSalary() {
		return this.salary;
	}

	public String getEmpInfo() {
		String result = this.employeeName + "의 부서는 " //
				+ this.department + "이고 직무는 " + this.job //
				+ "이고 급여는 " + this.salary + " 입니다";
		return result;
	}
}
