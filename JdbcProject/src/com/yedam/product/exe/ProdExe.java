package com.yedam.product.exe;

import com.yedam.product.Util;
import com.yedam.product.except.ExitException;
import com.yedam.product.menu.Menu;
import com.yedam.product.menu.TxnMenu;
import com.yedam.product.menu.ItemMenu;

public class ProdExe {
	private static ProdExe instance;

	private ProdExe() {
	}

	public static ProdExe getInstance() {
		if (instance == null) {
			instance = new ProdExe();
		}
		return instance;
	}

	// 전체 실행 메뉴.
	public void exec() {

		int choice;
		while (true) {
			Util.prompt("\n==============================================================");
			Util.prompt(" 0.종료 1.상품 2.입출고 ");
			choice = Util.promptInt("선택");
			try {
				switch (choice) {
				case Menu.ADD:
					itemMenu();
					break;
				case Menu.TXN:
					txnMenu();
					break;
				case Menu.EXIT:
					throw new ExitException("종료합니다.");
				default:
					System.out.println("1~3 중에 선택하세요.\n");
				}
			} catch (ExitException e) {
				Util.prompt(e.getMessage());
				break;
			}
		}
		System.out.println("end of prog.");
	} // end of exe()

	private void itemMenu() {
		ProdItemExe item = ProdItemExe.getInstance();

		while (true) {
			Util.prompt("\n--------------------------상품하위메뉴---------------------------");
			Util.prompt("0.이전메뉴 1.상품등록 2.상품수정 3.전체상품 4.상세정보 ");
			int menu = Util.promptInt("선택");

			switch (menu) {
			case ItemMenu.ADD_PLUS:
				item.addProduct();
				break;
			case ItemMenu.ADD_MOD:
				item.modProduct();
				break;
			case ItemMenu.ADD_LIST:
				item.listProduct();
				break;
			case ItemMenu.ADD_DETAIL:
				item.viewProduct();
				break;
			case ItemMenu.ADD_EXIT:
				return;
			}
		}
	} // end of addMenu()

	private void txnMenu() {
		ProdInOutExe inOut = ProdInOutExe.getInstance(); // 입출고관련.

		while (true) {
			Util.prompt("\n--------------------------입출하위메뉴---------------------------");
			Util.prompt("0.이전메뉴 1.입고 2.출고 3.재고 ");
			int menu = Util.promptInt("선택");

			switch (menu) {
			case TxnMenu.RCT:
				inOut.receiptProduct();
				break;
			case TxnMenu.ISU:
				inOut.issueProduct();
				break;
			case TxnMenu.INV:
				inOut.onhandProduct();
				break;
			case TxnMenu.EXIT:
				return;
			}
		}
	} // end of txnMenu()
}
