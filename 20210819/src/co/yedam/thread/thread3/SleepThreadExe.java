package co.yedam.thread.thread3;

import java.awt.Toolkit;

public class SleepThreadExe {
	public static void main(String[] args) {
		Toolkit toolkit = Toolkit.getDefaultToolkit();

		for (int i = 0; i < 10; i++) {
			toolkit.beep();

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("end of prog.");
	}
}
