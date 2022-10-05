package com.yedam.app;

public class Member {
	String id;
	String name;

	public Member() {
	}

	public Member(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", name=" + name + "]";
	}

	@Override
	public boolean equals(Object obj) {
		Member target = (Member) obj;
		return this.name.equals(target.name);
	}
}
