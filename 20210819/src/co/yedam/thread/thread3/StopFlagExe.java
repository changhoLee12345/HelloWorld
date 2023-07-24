package co.yedam.thread.thread3;

class PrintThread extends Thread {
	private boolean stop;

	public void setStop(boolean stop) {
		this.stop = stop;
	}

	@Override
	public void run() {
		while (!stop) {
			System.out.println("실행중");
		}
		System.out.println("자원정리..");
		System.out.println("실행종료..");

	}
}

public class StopFlagExe {
	public static void main(String[] args) {
		PrintThread thread = new PrintThread();
		thread.start();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		thread.setStop(true);

	}
}
