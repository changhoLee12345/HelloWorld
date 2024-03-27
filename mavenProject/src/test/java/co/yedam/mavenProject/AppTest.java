package co.yedam.mavenProject;

import org.apache.ibatis.session.SqlSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.yedam.mavenProject.common.DataSource;
import co.yedam.mavenProject.common.SearchDTO;
import co.yedam.mavenProject.mapper.BoardMapper;
import co.yedam.mavenProject.vo.BoardVO;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
	/**
	 * Create the test case
	 *
	 * @param testName name of the test case
	 */
	public AppTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(AppTest.class);
	}

	/**
	 * Rigourous Test :-)
	 */
	public void testApp() {
		assertTrue(true);

		SqlSession session = DataSource.getInstance().openSession(true);
		BoardMapper mapper = session.getMapper(BoardMapper.class);

		BoardVO vo = new BoardVO();
		vo.setTitle("modify title");
		vo.setContent("modify content");
		vo.setWriter("updatee");
		vo.setBoardNo(263);
		vo.setViewCnt(11);

		// 데이터 변경.
		SearchDTO search = new SearchDTO();
		search.setSearchCondition("title");
		search.setKeyword("every");
		search.setOrderBy("board_no desc");

		// 데이터 조회.
		vo = mapper.replyByBoard(512);

		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(vo);
		System.out.println(json);

	}
}
