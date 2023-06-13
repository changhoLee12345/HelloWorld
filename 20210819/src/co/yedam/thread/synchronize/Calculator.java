package co.yedam.thread.synchronize;

public class Calculator {
	private int memory;

	public int getMemory() {
		return memory;
	}

	public   void setMemory(int memory) {
		System.out.println(Thread.currentThread().getName());
		this.memory = memory;

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " : " + this.memory);
	}
}
