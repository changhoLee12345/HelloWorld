package co.yedam.io;

import java.io.Serializable;

public class Emp implements Serializable, Comparable<Emp> {

	int id;
	String name;
	String dept;

	// 생성자
	public Emp() {
	}

	public Emp(int id, String name, String dept) {
		super();
		this.id = id;
		this.name = name;
		this.dept = dept;
	}

	// settter/getter
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	// toString
	@Override
	public String toString() {
		return "Emp [id=" + id + ", name=" + name + ", dept=" + dept + "]";
	}

	@Override
	public boolean equals(Object obj) {
		Emp target = (Emp) obj;
		return this.id == target.id && this.name.equals(target.name);
	}

	@Override
	public int hashCode() {
		return id + name.hashCode();
	}

	@Override
	public int compareTo(Emp o) {
		return this.name.compareTo(o.name);
	}
}
