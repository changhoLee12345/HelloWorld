package co.yedam.thread.thread2;

class ThreadA extends Thread {
	public ThreadA() {
		setName("Thread-A");
	}

	public void run() {
		for (int i = 0; i < 2; i++) {
			System.out.println("Thread - " + getName());
		}
	}
}

class ThreadB extends Thread {
	public ThreadB() {
		setName("Thread-B");
	}

	public void run() {
		for (int i = 0; i < 2; i++) {
			System.out.println("Thread - " + getName());
		}
	}
}

public class ThreadNameExample {
	public static void main(String[] args) {
		Thread threadA = new ThreadA();
		threadA.start();

		Thread threadB = new ThreadB();
		threadB.start();

	}
}
