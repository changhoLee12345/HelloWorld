package com.date;

public class Main {
	public static void main(String[] args) {
		String ssn = "550404-1234567";
		System.out.println(checkInfo(ssn));
	}

	public static String checkInfo(String ssn) {
		String year, month, day, sex;

		if (ssn.length() < 13 || ssn.length() > 14) {
			return "잘못된 번호입니다";
		}

		String[] lnth = ssn.split("-");
		String[] chrs = ssn.split("");

		year = chrs[0] + chrs[1];
		month = chrs[2] + chrs[3];
		day = chrs[4] + chrs[5];

		if (lnth.length == 1) {
			if (chrs[6].equals("1") || chrs[6].equals("3")) {
				sex = "남자";
			} else if (chrs[6].equals("2") || chrs[6].equals("4")) {
				sex = "여자";
			} else {
				return "잘못된 성별값입니다";
			}

		} else if (lnth.length == 2) {
			if (chrs[7].equals("1") || chrs[7].equals("3")) {
				sex = "남자";
			} else if (chrs[7].equals("2") || chrs[7].equals("4")) {
				sex = "여자";
			} else {
				return "잘못된 성별값입니다";
			}

		} else {
			return "잘못된 번호입니다";
		}

		return year + "년 " + Integer.parseInt(month) + "월 " + Integer.parseInt(day) + "일 생, " + sex + "입니다.";
	}
}
