package co.edu;

public class BoardList {
	private Board[] boards;

	// 배열크기 초기화.
	public void init(int size) {
		boards = new Board[size];
	}

	// 배열에 한건 입력.
	public int addBoard(Board board) {
		// 더이상 저장공간 없을때..false
//		boolean check = false;
		int errorCase = -1; // 저장공간없음.
		for (int i = 0; i < boards.length; i++) {
			if (boards[i] != null && boards[i].getBoardNo() == board.getBoardNo()) {
				errorCase = 1; // 동일한 값이 있을경우의 에러.
				break;
			}
			if (boards[i] == null) {
				boards[i] = board;
				errorCase = 0; // 정상처리.
				break;
			}
		}
		return errorCase;
	}

	// 수정: 게시글번호 찾아서 내용, 제목 바꾸도록 하겠습니다.
	public boolean modifyBoard(Board board) {
		boolean check = false;
		for (int i = 0; i < boards.length; i++) {
			if (boards[i].getBoardNo() == board.getBoardNo()) {
				boards[i].setContent(board.getContent());
				boards[i].setTitle(board.getTitle());
				check = true;
				break;
			}
		}
		return check;
	}

	// 삭제: 게시글번호.
	public boolean removeBoard(int bNo) {
		boolean check = false;
		for (int i = 0; i < boards.length; i++) {
			if (boards[i].getBoardNo() == bNo) {
				boards[i] = null; // 배열의 위치 null대입.
				check = true;
				break;
			}
		}
		return check;
	}

	// 한건조회: 게시글번호.
	public Board searchBoard(int bNo) {
		for (int i = 0; i < boards.length; i++) {
			if (boards[i].getBoardNo() == bNo) {
				int currentCnt = boards[i].getSearchCnt();
				boards[i].setSearchCnt(currentCnt + 1); // 조회수 증가.
				return boards[i]; // 배열의 위치 null대입.
			}
		}
		return null;
	}

	// 게시글목록
	public Board[] boardList() {
		return boards;
	}

	// 작성자 조회기능.
	public Board[] getWriterList(String writer) {
		Board[] sBoards = new Board[5];

		for (int i = 0; i < boards.length; i++) { // 찾을 대상 배열.
			if (boards[i] != null && boards[i].getWriter().equals(writer)) {
				for (int j = 0; j < sBoards.length; j++) { // 이름 조회 반환 배열.
					if (sBoards[j] == null) {
						sBoards[j] = boards[i];
						break;
					}
				}
			}
		}

		return sBoards;
	}

}
