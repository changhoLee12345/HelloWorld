package com.dev;

import java.util.Scanner;

public class IfExample2 {
	public static void main(String[] args) {
		// 물건가격이 50000이상이면 배송비 0,
		// 그외에는 배송비 3000원.

		// 결제할 금액이 얼마인지를 보여주는 코드.

		// 결제할 금액은 ???? 입니다.

		Scanner scn = new Scanner(System.in);
		int price, shippingFee = 3000;
		System.out.println("물건의 가격을 입력하세요..");
		price = scn.nextInt();

//		if (price >= 50000) {
//			price = price;
//		} else {
//			price = price + shippingFee;
//		}
		price = (price >= 50000) ? price : price + shippingFee;

		System.out.println("결제할 금액은 " + price + "원 입니다.");
		scn.close();
	}
}
