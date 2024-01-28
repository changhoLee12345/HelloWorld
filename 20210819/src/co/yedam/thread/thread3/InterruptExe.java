package co.yedam.thread.thread3;

class PrintThread2 extends Thread {

	@Override
	public void run() {
		try {
			while (true) {
				System.out.println("실행중1..");
				Thread.sleep(1);
			}
		} catch (InterruptedException e) {
			System.out.println("자원정리1..");
			System.out.println("실행종료1..");
		}

	}
}

class PrintThread3 extends Thread {

	@Override
	public void run() {
		while (true) {
			System.out.println("실행중2...");
			if (Thread.interrupted()) {
				break;
			}
		}
		System.out.println("자원정리2..");
		System.out.println("실행종료2..");
	}

}

public class InterruptExe {

	public static void main(String[] args) {
		Thread thread = new PrintThread3();
		thread.start();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		thread.interrupt();

	}
}
