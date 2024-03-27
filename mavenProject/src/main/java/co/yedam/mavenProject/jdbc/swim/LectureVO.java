package co.yedam.mavenProject.jdbc.swim;

import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class LectureVO extends SwimVO {
	private String memId;
	private Date creationDate;
}
