package co.yedam.chap6;

/*1.설계 프로그램   : 국어성적을 처리할 프로그램
         data : int[]    <- 필드
         기능 : 전체출력 <- 메서드(함수)
         		합계
         		최댓값
*/
//표기법 : 카멜케이스,   스네이크케이스 : Kor_score
//2. 설계도를 작성(선언)
public class KorScore {
	int[] kor = new int[] { 100,300,50};
	
	public void print() {
		for(int temp : kor) {
			System.out.println(temp);
		}
	}	
	public void total() {
		int sum = 0;
		for(int temp : kor) {
			sum += temp;
		}
		System.out.println(sum);
	}	
	public void max() {
		int m=0;
		for(int temp : kor) {
			//if()
		}
		System.out.println(m);
	}
}
