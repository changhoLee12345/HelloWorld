package co.yedam.app;

class MyException extends Exception {
	public MyException() {

	}

	public MyException(String msg) {
		super(msg);
	}
}

public class ExceptionTest4 {
	public static void main(String[] args) {
		try {
			callMethod(3, 4);
		} catch (MyException e) {
			e.printStackTrace();
		}
	}

	public static int callMethod(int a, int b) throws MyException {
		int result = a - b;
		if (result < 0)
			throw new MyException("음의 결과 발생.");

		return result;
	}
}
