package co.edu;

import java.util.Date;

public class ChatVO {
	private int seq;
	private String content;
	private String writer;
	private Date creationDate;

	public ChatVO(int seq, String content, String writer, Date creationDate) {
		super();
		this.seq = seq;
		this.content = content;
		this.writer = writer;
		this.creationDate = creationDate;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	@Override
	public String toString() {
		return writer + " >> " + content;
	}

}
