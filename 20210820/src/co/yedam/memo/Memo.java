package co.yedam.memo;

import java.io.Serializable;

/**
 * 
 * @author dbale
 * 메모 하나를 저장
 */
public class Memo  implements Serializable{

	private int no;
	private String date;
	private String content;
	
	//생성자( 필드3개 모두 초기화, date/content 초기화,  content 초기화, 기본생성자 )
	public Memo(int no, String date, String content) {
		super();
		this.no = no;
		this.date = date;
		this.content = content;
	}

	public Memo(String date, String content) {
		super();
		this.date = date;
		this.content = content;
	}

	public Memo(String content) {
		//오늘날짜를 스트링으로 변환
		String date = "";
		this.date = date;
		this.content = content;
	}

	public Memo() {
		super();
	}

	
	//setter/getter
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	//toString
	@Override
	public String toString() {
		return "Memo [no=" + no + ", date=" + date + ", content=" + content + "]";
	}

	//equals (날짜비교)
	@Override
	public boolean equals(Object obj) {
		Memo target = (Memo)obj;
		return this.no == target.no && this.date.equals(target.date);
	}

	@Override
	public int hashCode() {
		return no+date.hashCode();
	}
	
}
