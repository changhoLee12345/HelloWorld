package co.yedam.thread.thread7;

class PrintThread1 extends Thread {
	private boolean stop;

	public void setStop(boolean stop) {
		this.stop = stop;
	}

	public void run() {
		while (!stop) {
			System.out.println("running...");
		}
		System.out.println("resources....");
		System.out.println("terminated....");
	}
}

public class StopFlagExe {
	public static void main(String[] args) {
		PrintThread1 thread = new PrintThread1();
		thread.start();

		try {
			Thread.sleep(1000);
		} catch (Exception e) {

		}

		thread.setStop(true);

	}
}
