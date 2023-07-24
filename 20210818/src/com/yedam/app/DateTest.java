package com.yedam.app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class DateTest {

	public static void main(String[] args) throws ParseException {
		// 현재날짜
		Date today = new Date();
		System.out.println(today.getTime()); // 1629253668393 1970/1/1 0 -> 1000*60*60*24*365*10

		// Calendar
		Calendar day1 = Calendar.getInstance();
		System.out.println(day1);
		System.out.println(day1.get(Calendar.YEAR));
		System.out.println(day1.get(Calendar.MONTH) + 1);
		System.out.println(day1.get(Calendar.DAY_OF_MONTH));
		System.out.println("요일번호:" + day1.get(Calendar.DAY_OF_WEEK));

		// 일수계산
		Calendar day2 = Calendar.getInstance();
		day2.set(2020, 7, 18);
		long result = day1.getTimeInMillis() - day2.getTimeInMillis();
		System.out.println("일수계산: " +(result / 1000 / 60 / 60 / 24));

		LocalDate day3 = LocalDate.now();
		LocalDate day4 = day3.plusDays(100);
		System.out.println("day4: " + day4);
		LocalDateTime day5 = LocalDateTime.now();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
		System.out.println("day5 : " + day5.format(format));

		// Duration, LocalTime, LocalDateTime, Period

		// date -> string
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh시 mm: ss u  ");
		String todayStr = sdf.format(today);
		System.out.println("format:" + todayStr);

		// string -> date
		String sdate = "2020-10-01 13:14:15";
		sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date ddate = sdf.parse(sdate);
		System.out.println(ddate);

		// static 메서드 호출
		System.out.println("static: " + DateUtil.dateToStr(today));
		System.out.println("static: " + DateUtil.dateToStr(today, "yyyy"));

		Date date3 = DateUtil.strToDate("2021/08/10");
		System.out.println("date3: " + date3);
	}
}
