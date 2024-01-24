package co.yedam.thread.thread4;

public class ThreadB extends Thread {
	public boolean stop = false;
	public boolean work = true;

	public void run() {
		while (!stop) {
			if (work) {
				System.out.println("ThreadB job");
			} else {
				Thread.yield();
			}

			try {
				Thread.sleep(200);
			} catch (Exception e) {

			}

		}
		System.out.println("ThreadB done");
	}

}
