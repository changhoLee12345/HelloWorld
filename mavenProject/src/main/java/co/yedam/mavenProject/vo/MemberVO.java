package co.yedam.mavenProject.vo;

import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode.Exclude;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class MemberVO {
	@NonNull
	private String memId;
	@NonNull
	private String memPw;
	@NonNull
	private String memName;
	@NonNull
	private String memPhone;

	private Date creationDate;
}
