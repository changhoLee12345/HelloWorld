package com.yedam.app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	/**
	 * 날짜를 문자열로 변환
	 * 
	 * @param date
	 * @return String
	 */
	public static String dateToStr(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String result = date.toString();
		result = date.toGMTString();
		result = date.toLocaleString();
		result = sdf.format(date);
		return result;
	}

	/**
	 * 주어진 패턴대로 날따를 문자로 변환
	 * 
	 * @param date    날짜
	 * @param pattern 형식
	 * @return 문자열
	 */
	public static String dateToStr(Date date, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(date);
	}

	public static Date strToDate(String date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		Date result = null;
		try {
			result = sdf.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return result;
	}

}
