package co.yedam.mavenProject.mapper;

import java.util.List;

import co.yedam.mavenProject.vo.BoardVO;

public interface BoardMapper {
	List<BoardVO> boardList();
	int insertBoard(BoardVO board);
	int updateBoard(BoardVO board);
}
