package co.yedam.app;

public class ScoreAppMain {

	public static void main(String[] args) {

		int[] kor = new int[5];
		kor[0] = 100;
		kor[1] = 80;
		kor[2] = 90;
		kor[3] = 50;
		kor[4] = 80;
		
		//전체 성적 조회
		for(int i=0; i<kor.length; i++) {
			System.out.println(kor[i]);
		}
		
		System.out.println("향상된 for문 사용");
		for( int  temp : kor) {
			System.out.println(temp);
		}
		
		//국어성적 합계 계산
		
	}
}
