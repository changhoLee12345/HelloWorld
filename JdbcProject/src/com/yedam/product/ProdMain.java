package com.yedam.product;

import com.yedam.product.exe.ProdExe;

public class ProdMain {
	public static void main(String[] args) {
		ProdExe saler = ProdExe.getInstance();
		saler.exec();
	}
}
