import java.util.Scanner;

/*
 * BOJ #2522 별 찍기 - 12
 * 시작일 : 2021-03-04
 * 완료일 : ``
 * 구현
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
			for(int j=0;j<=i;j++) {
				sb.append('*');
			}
			sb.append('\n');
		}
		for(int i=1;i<n;i++) {
			for(int j=0;j<i;j++) {
				sb.append(' ');
			}
			for(int j=n;j>i;j--) {
				sb.append('*');
			}
			sb.append('\n');
		}
		System.out.print(sb.toString());
		
	}

}
