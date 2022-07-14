package co.yedam.app;

public class MainArg {

	public static void main(String[] args) {
		if(args.length<2) {
			System.out.println("2개이상입력");
			System.exit(0);  
		}
		
		String num1 = args[0];
		String num2 = args[1];
		
		int n1 = Integer.parseInt(num1);
		int n2 = Integer.parseInt(num2);
		
		int result = n1 + n2;
		System.out.println(result);
	}

}
