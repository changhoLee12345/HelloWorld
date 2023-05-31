package com.yedam.app.b10871;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scanner =  new Scanner(System.in);
		int n = scanner.nextInt();
		int x = scanner.nextInt();
		
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = scanner.nextInt();
		}
		System.out.println(arr[n-1]);
		
	/*	
		String in = scanner.nextLine();
		String[] arr1= in.split(" ");
		
		System.out.println(n);
		System.out.println(x);
		System.out.println(arr1[0]);
		System.out.println(arr1.length);*/
		
		scanner.close();
	}

}
