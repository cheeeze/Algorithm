import java.util.Scanner;

/*
 * BOJ #10991 별 찍기 - 16
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
			for(int j=1;j<n-i;j++) {
				sb.append(' ');
			}
			sb.append('*');
			for(int j=0;j<i;j++) {
				sb.append(" *");
			}
			sb.append('\n');
		}
		System.out.print(sb.toString());
		sc.close();
	}

}
