package com.edu.variables;

import java.util.Arrays;
import java.util.Calendar;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;

public class HelloCal {
	public static void main(String[] args) {

		int year = 2022, month = 8;
		cal(year, month);

	}

	public static void cal(int year, int month) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month - 1);

		int startDay = cal.get(Calendar.DAY_OF_WEEK); // 첫날의 요일정보.
		int endDate = cal.getActualMaximum(Calendar.DATE); // 막날정보.

//		System.out.printf("%d, %d\n", startDay, endDate);
//		System.out.println(cal.get(Calendar.MONTH));

		Arrays.stream(new String[] { "Sun", "Mon", "Tue", "Wed", "Thr", "Fri", "Sat" })//
				.forEach(new Consumer<String>() {
					@Override
					public void accept(String t) {
						System.out.printf("%4s", t);
					}
				});
		System.out.println(); // 줄 바꿈.

		IntStream.range(0, startDay).forEach(new IntConsumer() {
			@Override
			public void accept(int v) {
				System.out.printf("%4s", " ");
			}
		});
		IntStream.rangeClosed(1, endDate).forEach(v -> {
			System.out.printf("%4d", v);
			if ((v + startDay) % 7 == 0) {
				System.out.println();
			}
		});

	}

}
