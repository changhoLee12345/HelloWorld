package co.yedam.thread.thread4;

public class YieldExe {
	public static void main(String[] args) {
		ThreadA thra = new ThreadA();
		ThreadB thrb = new ThreadB();

		thra.start();
		thrb.start();

		try {
			Thread.sleep(2000);
		} catch (Exception e) {

		}
		thra.work = false;

		try {
			Thread.sleep(2000);
		} catch (Exception e) {

		}
		thra.work = true;

		try {
			Thread.sleep(2000);
		} catch (Exception e) {

		}
		thra.stop = true;
		thrb.stop = true;
	}
}
