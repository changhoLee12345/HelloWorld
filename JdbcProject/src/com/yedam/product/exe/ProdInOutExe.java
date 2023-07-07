package com.yedam.product.exe;

import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import com.yedam.product.Util;
import com.yedam.product.dao.TxnDAO;
import com.yedam.product.vo.TxnVO;

public class ProdInOutExe {
	private static ProdInOutExe instance;

	private ProdInOutExe() {
	}

	public static ProdInOutExe getInstance() {
		if (instance == null)
			instance = new ProdInOutExe();
		return instance;
	}

	boolean testing = false;
	TxnDAO tdao = new TxnDAO(); // 입출고관련.

	public void receiptProduct() {
		if (testing) {
			Util.prompt("receipt");
			return;
		}
		String pcode = Util.promptString("상품코드");
		int qty = Util.promptInt("입고수량");
		if (tdao.receipt(pcode, qty)) {
			Util.prompt("입고완료.");
		} else {
			Util.prompt("처리실패.");
		}
	}

	public void issueProduct() {
		if (testing) {
			Util.prompt("issue");
			return;
		}
		String pcode = Util.promptString("상품코드");
		int qty = Util.promptInt("출고수량");
		if (qty > tdao.onhandCheck(pcode)) {
			Util.prompt("재고부족");
			return;
		}
		if (tdao.issue(pcode, qty)) {
			Util.prompt("출고완료.");
		} else {
			Util.prompt("처리실패.");
		}
	}

	public void onhandProduct() {
		if (testing) {
			Util.prompt("hand");
			return;
		}

		boolean overZero = false;

		Stack<Integer> history = new Stack<>();
		int totalCnt = tdao.pagingCount(overZero);
		int currPage = 1, startPage = 1, endPage;
		endPage = (int) (Math.ceil((double) totalCnt / 5));

		while (true) {
			if (history.size() != 0) {
				System.out.print("  0.이전메뉴  << ");
				for (int i = 1; i <= endPage; i++) {
					if (i == currPage) {
						System.out.print("[" + i + "] ");
					} else {
						System.out.print(i + " ");
					}
				}
				String val = Util.promptString(" >> ※상세이력은 상품코드 입력.\n\npage");
				try {
					currPage = Integer.parseInt(val);
				} catch (Exception e) {
					// 상품의 상세입출력정보.
					List<TxnVO> list = tdao.txnHistory(val);
					// ◎ P001 10 2023-06-16 10:25:50
					System.out.println("  -   Item  qty         입출날짜         ");
					System.out.println("=======================================");
					for (TxnVO vo : list) {
						System.out.println(vo.txnInfo());
					}
				}
			}
			if (currPage == 0) {
				break;
			}
			if (currPage < startPage || currPage > endPage) {
				Util.prompt(startPage + " ~ " + endPage + " 사이의 페이지를 선택하세요.");
				currPage = history.pop();
			}

			history.push(currPage);
			List<HashMap<String, Integer>> list = tdao.onhandPaging(currPage, overZero);// tdao.onhandList(overZero);
			Util.prompt(" ");
			for (int i = 0; i < list.size(); i++) {
				HashMap<String, Integer> product = list.get(i);
				Set<String> set = product.keySet();
				for (String pname : set) {
					System.out.printf("[상품코드] %s / [재고수량] %3d\n", pname, product.get(pname));
				}
			}
		}
	} // end of onhandProduct()
}
