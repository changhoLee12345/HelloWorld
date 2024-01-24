package co.yedam.thread.thread6;

public class WorkObject {

	public synchronized void methodA() {
		System.out.println("ThreadA. methodA. start.");
		notify();
		try {
			wait();
		} catch (InterruptedException e) {
			
		}
		
	}
	
	public synchronized void methodB() {
		System.out.println("ThreadA. methodB. start.");
		notify();
		try {
			wait();
		} catch (InterruptedException e) {
			
		}
		
	}
}
