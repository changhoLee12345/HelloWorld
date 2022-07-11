package co.yedam.app;

public class ExceptionTest2 {

	public static void main(String[] args) {

		String[] str = new String[] { "100", "a10", null, "30" };
		try {
			sub1(str);
		} catch (NumberFormatException e) {
			System.out.println(e.getMessage());
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public static void sub1(String[] a) throws NumberFormatException, ArrayIndexOutOfBoundsException {
		for (int i = 0; i < 5; i++) {
			int b = Integer.parseInt(a[i]);
			System.out.println(b);
		}
	}

}
