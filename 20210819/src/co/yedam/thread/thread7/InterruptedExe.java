package co.yedam.thread.thread7;

class PrintThread2 extends Thread {
	public void run() {
		// 1) try .. catch..
//		try {
//			while (true) {
//				System.out.println("running....");
//				Thread.sleep(1);
//			}
//		} catch (Exception e) {
//
//		}

		// 2) Thread.interrupted..
		while (true) {
			System.out.println("running....");
			if (Thread.interrupted()) {
				break;
			}
		}

		System.out.println("resources....");
		System.out.println("terminated....");
	}
}

public class InterruptedExe {
	public static void main(String[] args) {

		Thread thread = new PrintThread2();
		thread.start();

		try {
			Thread.sleep(1000);
		} catch (Exception e) {

		}
		thread.interrupt();

	}
}
