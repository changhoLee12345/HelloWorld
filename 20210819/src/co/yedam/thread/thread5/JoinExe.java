package co.yedam.thread.thread5;

public class JoinExe {
	public static void main(String[] args) {
		SumThread sumTh = new SumThread();
		sumTh.start();

		try {
			sumTh.join();
		} catch (Exception e) {

		}
		System.out.println("1 ~ 100 sum: " + sumTh.getSum());
	}
}
