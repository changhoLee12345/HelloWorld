package memomanage;

import java.util.List;

public class MemoApp {

	static MemoList memos = new MemoListImpl();

	public static void main(String[] args) {

		int choice;

		while (true) {
//			showMenu();
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
