package com.yedam.product.vo;

import java.util.Date;

import lombok.Data;

@Data
public class ProductVO {
	private String prodCode;
	private String prodName;
	private String prodDesc;
	private int rctPrice;
	private int salePrice;
	private int safeQty;
	private Date createDate;
	private Date updateDate;

	public String briefInfo() {
		String info = "";
		info += " ◎ 상품코드: " + prodCode + ", 상품명: " + prodName //
				+ ", 입고가격: " + rctPrice + ", 판매가격: " //
				+ salePrice + ", 안전재고: " + safeQty;
		return info;
	}

	public String detailInfo() {
		String info = "\n";
		info += "[상품코드] " + prodCode + "    [상품명] " + prodName + "\n";
		info += "[설명] " + prodDesc + "\n";
		info += "[입고가격] " + rctPrice + "\t[판매가격] " + salePrice + "\t[안전재고] " + safeQty + "\n";
		info += "\n";
		return info;
	}
}
