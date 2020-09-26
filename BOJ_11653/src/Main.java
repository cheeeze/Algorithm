import java.util.Scanner;

/*
 * BOJ #11653 소인수분해
 * 시작일 : 2020-09-26
 * 완료일 : ``
 * 정수론, 구현
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		StringBuilder sb = new StringBuilder();
		for(int i=2;i<=n;i++) {
			while(n%i==0) {
				n /= i;
				sb.append(i+"\n");
			}
		}
		
		System.out.print(sb.toString());
	}

}
