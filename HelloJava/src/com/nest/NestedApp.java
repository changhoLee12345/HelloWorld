package com.nest;

import java.util.Scanner;

class Friend {
	String name;
	String phone;
	int age;

	public Friend(String name, String phone, int age) {
		super();
		this.name = name;
		this.phone = phone;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Friend [name=" + name + ", phone=" + phone + ", age=" + age + "]";
	}

}

public class NestedApp {

	private Friend[] friends = new Friend[10];
	private Scanner scn = new Scanner(System.in);

	private interface FriendService {
		void add();

		void modify();

		void list();

		void addArray(Friend friend);

	}

	private class FriendApp implements FriendService {

		@Override
		public void add() {
			System.out.println("name>>");
			String name = scn.next();
			System.out.println("phone>>");
			String phone = scn.next();
			System.out.println("age>>");
			int age = scn.nextInt();
			Friend friend = new Friend(name, phone, age);
			addArray(friend);
		}

		@Override
		public void modify() {

		}

		@Override
		public void list() {
			for (Friend friend : friends) {
				if (friend != null)
					System.out.println(friend);
			}
		}

		@Override
		public void addArray(Friend friend) {
			for (int i = 0; i < friends.length; i++) {
				if (friends[i] == null) {
					friends[i] = friend;
					break;
				}
			}
		}

	}

	public void execute() {
		FriendApp app = new FriendApp();
		app.add();
		app.list();
	}

//	public static void main(String[] args) {
//
//		FriendApp app = new FriendApp();
//		app.add();
//		app.list();
//	}
}
