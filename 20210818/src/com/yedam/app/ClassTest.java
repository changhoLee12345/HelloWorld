package com.yedam.app;

import java.lang.reflect.Field;

public class ClassTest {

	public static void main(String[] args) {

		Class c = Member.class;
		System.out.println(c.getName());
		System.out.println(c.getPackage());

		Field[] fields = c.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			System.out.println(fields[i].getName());
		}

		System.out.println(c.getResource("/com/yedam/app/a.txt").getPath());
		// reflection : ?
	}

}
