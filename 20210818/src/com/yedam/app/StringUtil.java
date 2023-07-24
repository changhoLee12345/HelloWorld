package com.yedam.app;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StringUtil {
	/**
	 * 주민번호에서 성별 추출
	 * 
	 * @param ssn 주민번호
	 * @return 성별
	 * @author kym
	 * @since jdk1.4
	 */
	public static String findSex(String ssn) {
		if (ssn == null || ssn.isEmpty()) {
			return null;
		}
		char sex = ssn.charAt(7);
		String result = null;
		switch (sex) {
		case '1':
		case '3':
		case '5':
			result = "남";
			break;
		case '2':
		case '4':
		case '6':
			result = "여";
		}
		return result;
	}

	/*
	 * 주민번호 체크. 13자리이거나 14자리이면서 공백이나 '-'이 들어간 경우를 계산해서 검증.
	 */
	public static String findGender(String ssn) {
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyymmdd");
		String yyyymmdd = sdf.format(today);

		String strGen = "" + ssn.charAt(ssn.length() - 7);
		boolean over2000 = Integer.parseInt(ssn.substring(0, 2)) > Integer.parseInt(yyyymmdd.substring(2, 4));

		if (over2000) {
			if (strGen.equals("1"))
				return "남자";
			else if (strGen.equals("2"))
				return "여자";
			else
				return "에러";
		} else {
			if (strGen.equals("3"))
				return "남자";
			else if (strGen.equals("4"))
				return "여자";
			else
				return "에러";
		}
	}

	/**
	 * 파일경로에서 파일명 추출
	 * 
	 * @param path 파일경로명
	 * @return 파일명
	 * @author kym
	 * @since jdk1.4
	 */
	public static String findFileName(String path) {
		if (path == null || path.isEmpty()) {
			return null;
		}
		return path.substring(path.lastIndexOf("/") + 1);
	}
}
