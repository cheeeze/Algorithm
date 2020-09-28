import java.util.Scanner;

/*
 * BOJ #5585 거스름돈
 * 시작일 : 2020-09-28
 * 완료일 : ``
 * 그리디, 구현
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		n = 1000-n;
		int answer = 0;
		while(n>0) {
			if(n>=500) {
				n -= 500;
				answer++;
			}else if(n>=100) {
				n -= 100;
				answer++;
			}else if(n>=50) {
				n -= 50;
				answer++;
			}else if(n>=10) {
				n -= 10;
				answer++;
			}else if(n>=5){
				n -= 5;
				answer++;
			}else {
				answer += n;
				n = 0;
			}
		}
		System.out.println(answer);

	}

}
