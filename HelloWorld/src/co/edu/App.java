package co.edu;

import java.util.List;
import java.util.Scanner;

public class App {

	Scanner scn = new Scanner(System.in);
	String user;
	int firstSeq = Integer.MAX_VALUE;
	int prevSeq = 0;
	int lastSeq = Integer.MIN_VALUE;

	public void start() {

		Runnable r1 = new Runnable() {

			@Override
			public void run() {
				ChatDAO dao = new ChatDAO();

				while (true) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					showChat(dao.getList());
				}
			}

		};

		Runnable r2 = new Runnable() {

			@Override
			public void run() {
				System.out.println("id:");
				user = scn.nextLine();
				System.out.println(user + "님이 입장했습니다.");
				// 입장했습니다.
				while (true) {
//					System.out.print("메세지 입력: ");
					String content = scn.nextLine();
					if (content.equals("stop")) {
						break;
					}
					ChatDAO dao = new ChatDAO();
					ChatVO vo = new ChatVO(0, content, user, null);
					dao.addChat(vo);
				}
				System.out.println("end.");
			}

		};

		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		t1.start();
		t2.start();

	}

	boolean lastSeqChanged = false;

	public void showChat(List<ChatVO> chatList) {

		// 최초 화면을 보여줄때 10개까지만 채팅목록을 보여주려고 작업중.
		chatList.stream().forEach(vo -> {
			if (vo.getSeq() < firstSeq) {
				firstSeq = vo.getSeq();
			}
			if (vo.getSeq() > lastSeq) {
				lastSeq = vo.getSeq();
				lastSeqChanged = true;
			}
		});

		// 바뀐 내용이 있는것만 추가해서 보여주려고...
		for (ChatVO vo : chatList) {
			if (vo.getSeq() > prevSeq) {
				if (vo.getWriter().equals(user)) {
					vo.setWriter("당신");
				}
				System.out.println(vo.toString());
				prevSeq = vo.getSeq();
			}
		}

	}

}
