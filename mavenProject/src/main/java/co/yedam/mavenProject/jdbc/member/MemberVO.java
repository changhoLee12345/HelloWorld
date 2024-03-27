package co.yedam.mavenProject.jdbc.member;

import java.util.Date;

import lombok.Data;

@Data
public class MemberVO {
	private String memId;
	private String memPw;
	private String memName;
	private String memPhone;
	private Date creationDate;
}
