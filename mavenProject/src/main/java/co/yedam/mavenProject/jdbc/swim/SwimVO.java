package co.yedam.mavenProject.jdbc.swim;

import lombok.Data;

@Data
public class SwimVO {
	private String swimCode;
	private String swimName;
	private String coach;
	private int swimFee;
	private String enabled;
}
