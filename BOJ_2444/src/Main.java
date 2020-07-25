import java.util.Scanner;

/*
 * BOJ #2444 별 찍기 - 7
 * 시작일 : 2020-07-25
 * 완료일 : ``
 * 출력
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++) {
			for(int j=n-i-1;j>0;j--) {
				sb.append(' ');
			}
			for(int j=1;j<=i*2+1;j++) {
				sb.append('*');
			}
			sb.append('\n');
		}
		for(int i=n-1;i>0;i--) {
			for(int j=n-i;j>0;j--) {
				sb.append(' ');
			}
			for(int j=1;j<=i*2-1;j++) {
				sb.append('*');
			}
			sb.append('\n');
		}
		System.out.println(sb.toString());

	}

}
