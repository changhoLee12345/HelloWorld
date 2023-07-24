package co.yedam.thread.thread2;

class ThreadA extends Thread {
	public ThreadA() {
		setName("Thread-A");
	}

	public void run() {
		for (int i = 0; i < 2; i++) {
			System.out.println("Thread 이름 - " + getName());
		}
	}
}

class ThreadB extends Thread {
	public ThreadB() {
		setName("Thread-B");
	}

	public void run() {
		for (int i = 0; i < 2; i++) {
			System.out.println("Thread 이름 - " + getName());
		}
	}
}

public class ThreadNameExample {
	public static void main(String[] args) {

		Thread mainThread = Thread.currentThread();
		System.out.println("프로그램 시작: 스레드 이름: " + mainThread.getName());

		Thread threadA = new ThreadA();
		System.out.println("작업스레드 이름: " + threadA.getName());
		threadA.start();

		Thread threadB = new ThreadB();
		System.out.println("작업스레드 이름: " + threadB.getName());
		threadB.start();

	}
}
