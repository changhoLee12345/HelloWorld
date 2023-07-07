package com.yedam.product.exe;

import java.util.List;
import java.util.Stack;

import com.yedam.product.Util;
import com.yedam.product.dao.ProdDAO;
import com.yedam.product.vo.ProductVO;

public class ProdItemExe {
	private static ProdItemExe instance;

	private ProdItemExe() {
	}

	public static ProdItemExe getInstance() {
		if (instance == null)
			instance = new ProdItemExe();
		return instance;
	}

	// 필요한 항목들 선언.
	ProdDAO dao = new ProdDAO(); // 상품관련.
	boolean testing = false;

	public void addProduct() {
		if (testing) {
			Util.prompt("1.상품등록");
			return;
		}

		String code = Util.promptString("상품코드");
		String name = Util.promptString("상품명");
		String desc = Util.promptString("상품설명");
		int rprice = Util.promptPrice("입고가격");
		int sprice = Util.promptPrice("판매가격");
		int sqty = Util.promptPrice("안전재고");

		ProductVO vo = new ProductVO();
		vo.setProdCode(code);
		vo.setProdName(name);
		vo.setProdDesc(desc);
		vo.setRctPrice(rprice);
		vo.setSalePrice(sprice);
		vo.setSafeQty(sqty);

		if (dao.insert(vo)) {
			dao.update(vo);
			Util.prompt("등록성공.");
		} else {
			Util.prompt("등록실패");
		}

	}

	// 상품정보수정.
	public void modProduct() {
		if (testing) {
			Util.prompt("2.상품수정");
			return;
		}
		String code = Util.promptString("상품코드");
		String name = Util.promptString("상품명");
		String desc = Util.promptString("상품설명");
		int rprice = Util.promptPrice("입고가격");
		int sprice = Util.promptPrice("판매가격");
		int sqty = Util.promptPrice("안전재고");

		ProductVO vo = new ProductVO();
		vo.setProdCode(code);
		vo.setProdName(name);
		vo.setProdDesc(desc);
		vo.setRctPrice(rprice);
		vo.setSalePrice(sprice);
		vo.setSafeQty(sqty);

		if (dao.update(vo)) {
			Util.prompt("수정성공.");
		} else {
			Util.prompt("수정실패");
		}
	}

	// 전체상품.
	public void listProduct() {
		if (testing) {
			Util.prompt("3.상품목록");
			return;
		}
		// stack 에 넣어서 조회한 페이지.
		Stack<Integer> history = new Stack<Integer>();

		// 건수가 5개 넘어가면 페이징하기.
		List<ProductVO> list = dao.list();

		final int cntPer = 5;
		int totalCnt = list.size();
		int firstPage = 1, currPage = 1;
		int lastPage = (int) Math.ceil((double) totalCnt / cntPer);

		while (true) {
			if (history.size() != 0) {
				System.out.print("\n      0.이전메뉴   << ");
				for (int i = firstPage; i <= lastPage; i++) {
					if (i == currPage) {
						System.out.print("[" + i + "] ");
					} else {
						System.out.print(i + " ");
					}
				}
				Util.prompt(" >> ※상세조회: 상품코드입력. ");
				System.out.println();
				String val = "";
				try {
					// 페이지 리스트 보기.
					val = Util.promptString("page");
					currPage = Integer.parseInt(val);

				} catch (Exception e) {
					// 상품 상세보기.
					ProductVO prod = dao.search(val);
					if (prod == null) {
						Util.prompt("정보가 없습니다.");
					} else {
						Util.prompt(prod.detailInfo());
					}
				}
				if (currPage == 0) {
					return;
				}
				if (currPage < 0 || currPage > lastPage) {
					Util.prompt("없는 페이지입니다.");
					currPage = history.pop(); // 이전페이지를 다시 보여주기 위해서.
				}
			}
			history.push(currPage); //
			// 보여줄 페이지의 첫째데이터 마지막데이터 계산.
			int start = (currPage - 1) * cntPer;
			int last = currPage * cntPer;
			if (last > totalCnt) {
				last = totalCnt;
			}
			for (int i = start; i < last; i++) {
				Util.prompt(list.get(i).briefInfo());
			}

		}
	}

	// 상세보기
	public void viewProduct() {
		if (testing) {
			Util.prompt("4.상품상세");
			return;
		}
		String pcode = Util.promptString("상품코드");
		ProductVO prod = dao.search(pcode);
		if (prod == null) {
			Util.prompt("정보가 없습니다.");
		} else {
			Util.prompt(prod.detailInfo());
		}
	}

	// end of method.
}
