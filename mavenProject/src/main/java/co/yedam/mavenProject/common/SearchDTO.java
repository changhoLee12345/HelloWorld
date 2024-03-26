package co.yedam.mavenProject.common;

import lombok.Data;

@Data
public class SearchDTO {
	private int bno;
	private String searchCondition;
	private String keyword;
	private String orderBy;
}
