import java.util.Scanner;

/*
 * BOJ #2445 별 찍기 - 8
 * 시작일 : 2021-03-04
 * 완료일 : ``
 * 구현
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<=n;i++) {
			for(int j=0;j<i;j++) {
				sb.append('*');
			}
			for(int j=n;j>i;j--) {
				sb.append("  ");
			}
			for(int j=0;j<i;j++) {
				sb.append('*');
			}
			sb.append('\n');
		}
		for(int i=n-1;i>0;i--) {
			for(int j=0;j<i;j++) {
				sb.append('*');
			}
			for(int j=n;j>i;j--) {
				sb.append("  ");
			}
			for(int j=0;j<i;j++) {
				sb.append('*');
			}
			sb.append('\n');
		}
		System.out.print(sb.toString());

	}

}
