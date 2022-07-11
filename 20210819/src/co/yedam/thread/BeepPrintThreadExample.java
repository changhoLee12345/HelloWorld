package co.yedam.thread;

public class BeepPrintThreadExample {
	public static void main(String[] args) {
//		Thread beep = new Thread(new BeepTask()); // 1. Runnable 구현객체로 쓰레드 생성.
		Thread beep = new WorkerThread(); // 2. Thread 하위 클래스로 쓰레드 생성.
		beep.start();

		for (int i = 0; i < 5; i++) {
			System.out.println("print");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}
}
