package com.yedam.product.vo;

import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.Data;

@Data
public class TxnVO {
	private int txnId;
	private String prodCode;
	private int qty;
	private Date txnDate;

	public String txnInfo() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		String info = "";
		info += (qty > 0 ? "[입고]" : "[출고]") + " " + prodCode + "  " //
				+ String.format("%3d", qty) + "  " + sdf.format(txnDate);

		return info;
	}
}
