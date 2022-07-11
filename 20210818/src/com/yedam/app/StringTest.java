package com.yedam.app;

public class StringTest {

	public static void main(String[] args) {

		String ssn = "901210-1231234";

		Object obj = new Object();

		// 문자열길이
		int s = ssn.length();
		System.out.println("길이: " + s);

		// 성별
		System.out.println("성별: " + StringUtil.findSex(ssn));

		// 출생년도
		String year = ssn.substring(0, 2);
		System.out.println("년도: " + year);

		String fname = "c:/images/2021/home.png";

		// 확장자
		// int idx = fname.indexOf(".");
		String ext = fname.substring(fname.indexOf(".") + 1);
		System.out.println("확장자: " + ext);

		// 파일명
		String name = StringUtil.findFileName(fname);
		System.out.println("파일명: " + name);

		String[] ff = name.split("[.]");
		System.out.println(ff[0] + "----" + ff[1]);

		// 치환
		String result = fname.replace("2021", "2020");
		System.out.println(fname);
		System.out.println(result);

		// 스트링 비교
		String s1 = "hello";
		String s2 = "hello";
		String s3 = new String("hello");
		String s4 = new String("hello");
		System.out.println(s1 == s2);
		System.out.println(s3.equals(s4));
		System.out.println(s1 == s3);

		// 문자열 연산, 조작 (+) StringBuffer, StringBuilder
		StringBuffer sb = new StringBuffer();
		sb.append("hi").append("every").append("buy"); // "hi" + "ev" + "buy" 보다는 성능이 우월
		sb.replace(0, 2, "happy");
		System.out.println(sb);
		String str = sb.toString();

	}
}
