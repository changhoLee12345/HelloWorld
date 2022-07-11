package co.yedam.memo;

import java.util.Scanner;

public class MemoApp {

	public static void main(String[] args) {
		MemoManager memoManage = MemoManager.getInstance();
		Scanner scanner = new Scanner(System.in);
		int choice;
		while(true) {
			try {
				//메뉴출력
				System.out.println("1.등록 2.검색 3.삭제 4.종료");
				//메뉴번호입력
				System.out.print("번호>");
				choice = Integer.parseInt(scanner.nextLine());
				if( choice <  MENU.INSERT || choice > MENU.EXIT) {
					throw new MenuException(choice);
				}
				switch(choice) {
				case MENU.INSERT: memoManage.inputData(); break;
				case MENU.SEARCH: memoManage.searchData(); break;
				case MENU.DELETE: memoManage.deleteData(); break;
				case MENU.EXIT:   memoManage.storeToFile(); 
				                  System.exit(0);
				}
			} catch(MenuException e) { 
				e.showMessage();
			}
		}
	}

}
