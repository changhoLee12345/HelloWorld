package com.edu.api;

public class IDCheck {

	public String getGender2(String sno) {
		String newSno = sno.replace("-", "");
		newSno = newSno.replace(" ", "");
		String result = null;
		if (sno.length() == 13) { // 7번째
			char no = newSno.charAt(6); // 1 => ??
			if (no == '1' || no == '3') {
				result = "남자";
			} else if (no == '2' || no == '4') {
				result = "여자";
			} else {
				result = "잘못된 번호입니다.";
			}

		} else {
			result = "잘못된 번호입니다.";
		}
		return result;
	}
	// 주민번호 입력 -> 950304-1234567, 000205-4567890
	// 950304-1234567, 950304 1234567, 9503041234567

	// String getGender() -> 남자, 여자.
	public String getGender1(String sno) {
		String result = null; // 초기화.
		if (sno.length() == 14) { // 8번째
			char no = sno.charAt(7); // 1 => ??
			if (no == '1' || no == '3') {
				result = "남자";
			} else if (no == '2' || no == '4') {
				result = "여자";
			} else {
				result = "잘못된 번호입니다.";
			}

		} else if (sno.length() == 13) { // 7번째
			char no = sno.charAt(6); // 1 => ??
			if (no == '1' || no == '3') {
				result = "남자";
			} else if (no == '2' || no == '4') {
				result = "여자";
			} else {
				result = "잘못된 번호입니다.";
			}

		} else {
			result = "잘못된 번호입니다.";
		}

		return result;
	}

	public String getGender(String ssno) {

//		ssno = ssno.replace("-", "");
//		ssno = ssno.replace(" ", "");
		ssno = ssno.replaceAll("\\W", "");
		System.out.println(ssno);

		if (ssno.charAt(6) == '1' || ssno.charAt(6) == '3') {
			return "남자";
		} else if (ssno.charAt(6) == '2' || ssno.charAt(6) == '4') {
			return "여자";
		} else {
			return "잘못된 번호입니다";
		}
	}

}
