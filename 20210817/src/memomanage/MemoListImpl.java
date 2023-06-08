package memomanage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MemoListImpl implements MemoList {

	ArrayList<Memo> list = new ArrayList<>();
	Scanner scanner = new Scanner(System.in);

	@Override
	public void input(Memo memo) {
		// 리스트에 추가
		list.add(memo);
	}

	@Override
	public void print() {
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getNo());
			System.out.println(list.get(i).getDate());
			System.out.println(list.get(i).getContent());
		}
	}

	@Override
	public void update() {

	}

	@Override
	public void delete(int no) {

	}

	@Override
	public void delete(String date) {

	}

	@Override
	public void search(int no) {

	}

	@Override
	public void search(String date) {

	}

	@Override
	public void delete(int no, String date) {

	}

	@Override
	public void searchContent(String content) {

	}

	@Override
	public List<Memo> selectAll() {
		return list;
	}

}
