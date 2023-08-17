package com.edu;

public class ExchangeExample {
	public static void main(String[] args) {
		int cnt50000 = 0, remain50000 = 0, cnt10000 = 0, remain10000 = 0, cnt5000 = 0, remain5000 = 0, cnt1000 = 0,
				remain1000 = 0, cnt500 = 0, remain500 = 0, cnt100 = 0;

		int originVal = 75300;

		cnt50000 = originVal / 50000;
		remain50000 = originVal % 50000;

		if (remain50000 != 0) {
			cnt10000 = remain50000 / 10000;
			remain10000 = remain50000 % 10000;
		}
		if (remain10000 != 0) {
			cnt5000 = remain10000 / 5000;
			remain5000 = remain10000 % 5000;
		}
		if (remain5000 != 0) {
			cnt1000 = remain5000 / 1000;
			remain1000 = remain5000 % 1000;
		}
		if (remain1000 != 0) {
			cnt500 = remain1000 / 500;
			remain500 = remain1000 % 500;
		}
		if (remain500 != 0) {
			cnt100 = remain500 / 100;
		}

		System.out.printf("75300원은 5만원 %d장, 1만원 %d장, 5천원 %d장, 1천원 %d장, 5백원 %d장, 1백원 %d장이 필요합니다.", //
				cnt50000, cnt10000, cnt5000, cnt1000, cnt500, cnt100);

	}
}
