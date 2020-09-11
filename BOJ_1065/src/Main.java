import java.util.Scanner;

/*
 * BOJ #1065 한수
 * 시작일 : 2020-09-11
 * 완료일 : ``
 * 구현
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int answer = 0;
		for(int i=1;i<=n;i++) {
			if(i<100) {
				answer = i;
			}else if(i==1000) {
				break;
			}else{
				int k = i;
				int a = k%10;
				k/=10;
				int b = k%10;
				k/=10;
				if(a-b==b-k) {
					answer++;
				}				
			}
			
		}
		System.out.println(answer);

	}

}
