import java.util.Scanner;

/*
 * BOJ #2446 별 찍기 - 9
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
			for(int j=0;j<i;j++) {
				sb.append(' ');
			}
			int star = (n-i)*2-1;
			for(int j=0;j<star;j++) {
				sb.append('*');
			}
			sb.append('\n');
		}
		for(int i=n-2;i>=0;i--) {
			for(int j=0;j<i;j++) {
				sb.append(' ');
			}
			int star = (n-i)*2-1;
			for(int j=0;j<star;j++) {
				sb.append('*');
			}
			sb.append('\n');
		}
		System.out.print(sb.toString());

	}

}
