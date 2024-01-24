package co.yedam.thread.thread4;

public class TargetThread extends Thread {

	public void run() {
		for (long i = 0; i < 1000000000000000000L; i++) {

		}

		try {
			Thread.sleep(2000);
		} catch (Exception e) {

		}

		for (long i = 0; i < 1000000000000000000L; i++) {

		}

	}
}
