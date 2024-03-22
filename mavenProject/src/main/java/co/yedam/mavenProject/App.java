package co.yedam.mavenProject;

import org.apache.ibatis.session.SqlSession;

import co.yedam.mavenProject.common.DataSource;
import co.yedam.mavenProject.mapper.BoardMapper;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		SqlSession session = DataSource.getInstance().openSession();
		BoardMapper mapper = session.getMapper(BoardMapper.class);
		mapper.boardList().forEach(board -> {
			System.out.println(board);
		});
	}
}
