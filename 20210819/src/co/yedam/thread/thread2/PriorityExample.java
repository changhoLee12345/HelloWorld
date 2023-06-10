package co.yedam.thread.thread2;

/*
 * 쓰레드의 우선순위 지정.
 * 1 ~ 10 의 범위에 대해 우선순위 지정.
 */

class CalcThread extends Thread {
	public CalcThread(String name) {
		setName(name);
	}

	@Override
	public void run() {
		for (int i = 0; i < 2000000000; i++) {
			if (i % 100000000 == 0)
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		}
		System.out.println(getName());
	}
}

public class PriorityExample {
	public static void main(String[] args) {

		for (int i = 1; i <= 10; i++) {
			Thread thread = new CalcThread("thread-" + i);
			if (i != 10) {
				thread.setPriority(Thread.MIN_PRIORITY);
			} else {
				thread.setPriority(Thread.MAX_PRIORITY);
			}
			thread.start();
		}
	}
}
