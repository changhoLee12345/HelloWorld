package memomanage;

import java.util.List;

public class MemoExe {

	MemoList memos = new MemoListImpl();

	public void execute() {
		int choice;

		while (true) {
			System.out.println("1.추가 2.수정 3.삭제 4.조회 5.전체조회 6.종료");
			System.out.print("선택> ");

			choice = MenuViewer.keyboard.nextInt();
			MenuViewer.keyboard.nextLine();

			switch (choice) {
			case 1:
//				memos.inputData();
				memos.input(null);
				break;
			case 2:
//				memos.searchData();
				memos.search(null);
				break;
			case 3:
//				memos.deleteData();
				memos.delete(null);
				break;
			case 4:
//				memos.storeToFile();
				return;
			}
		}
	}

	public void showMenu() {
		// 번호
		int no = ScannerUtil.readInt("번호");
		// 날짜
		String date = ScannerUtil.readDate("날짜");
		// 내용
		String content = ScannerUtil.readMultiLine();

		memos.input(new Memo(no, date, content));

		List<Memo> list = memos.selectAll();
		for (Memo memo : list) {
			System.out.println(memo.getNo() + ":" + memo.getDate());
		}

		// 번호
		no = ScannerUtil.readInt("삭제번호");
		// 날짜
		date = ScannerUtil.readDate("삭제날짜");
		memos.delete(no, date);
	}

}
