package co.yedam.thread.thread6;

public class WaitNotifyExe {
	public static void main(String[] args) {
		WorkObject sharedObject = new WorkObject();

		ThreadA tha = new ThreadA(sharedObject);
		ThreadB thb = new ThreadB(sharedObject);

		tha.start();
		thb.start();
	}
}
