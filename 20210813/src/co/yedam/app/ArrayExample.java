package co.yedam.app;

/*
 * 2차원 배열
 * 국어, 영어, 수학
 */
public class ArrayExample {

	public static void main(String[] args) {

		// int kor[] =new int[10]{100,80,10 };
		// int eng[] =new int[10];
		// int mat[] =new int[10];

		int score[][] = new int[][] { // 점수
				{ 100, 80, 10, 40 }, // 국어
				{ 100, 100, 30, 100 }, // 영어
				{ 100, 50, 100, 60 } // 수학
		};

		// 국어성적
		System.out.println("=====국어=======");
		for (int i = 0; i < score[0].length; i++) {
			System.out.println(score[0][i]);
		}

		System.out.println("=====영어=======");
		for (int i = 0; i < score[1].length; i++) {
			System.out.println(score[1][i]);
		}

		System.out.println("=====국어 영어 수학=======");
		for (int i = 0; i < score[1].length; i++) {
			System.out.println(score[0][i] + " " + score[1][i] + " " + score[2][i]);
		}
//		학생0 100 100 100 
//		학생1 80 100 50 
//		학생2 10 30 100 
//		학생3 40 100 60

		System.out.println("=====국어 영어 수학 다중 for문 =======");
		for (int i = 0; i < score[0].length; i++) {

			for (int s = 0; s < score.length; s++) {
				System.out.print(score[s][i] + " ");
			}
			System.out.println();
		}

//		 과목별로 출력 
//		국어 : 100,80,10,40 
//		영어 : 100,100,30,100 
//		수학 : 100,50,100 ,60

		String[] className = new String[] { "국어", "영어", "수학" };
		System.out.println("=====과목별 출력 =======");
		int i = 0;
		for (int[] arr : score) {
			System.out.print(className[i++] + " ");
			for (int s : arr) {
				System.out.print(s + " ");
			}
			System.out.println();
		}

	}

}
