package memomanage;

import java.util.List;

public interface MemoList {
	
	//등록
	void input(Memo memo);
	
	//수정
	void update();
	
	//삭제
	void delete(int no);      			//번호삭제
	void delete(String date); 			//날짜삭제
	void delete(int no, String date); 	//날짜삭제
	
	//단건조회
	void search(int no);				//번호 1건만조회
	void search(String date);			//해당 날짜의 데이터 모두 조회
	void searchContent(String content); //내용검색(단어가 포함되어 있으면)
	
	//전체조회
	void print();
	List<Memo> selectAll();
}
