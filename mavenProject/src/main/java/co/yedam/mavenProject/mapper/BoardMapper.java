package co.yedam.mavenProject.mapper;

import java.util.List;

import co.yedam.mavenProject.common.SearchDTO;
import co.yedam.mavenProject.vo.BoardVO;

public interface BoardMapper {
	List<BoardVO> boardList();
	int insertBoard(BoardVO board);
	int updateBoard(BoardVO board);
	BoardVO getBoard(BoardVO board);
	List<BoardVO> searchList(SearchDTO search);
//	List<BoardVO> replyByBoard(int bno);
	BoardVO replyByBoard(int bno);
}
