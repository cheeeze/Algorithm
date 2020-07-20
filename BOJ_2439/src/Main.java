import java.util.Scanner;

/*
 * BOJ #2439 별 찍기 - 2
 * 시작일 : 2020-07-20
 * 완료일 : ``
 * 구현-반복문
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<=n;i++) {
			for(int j=0;j<n-i;j++) {
				sb.append(' ');
			}
			for(int j=0;j<i;j++) {
				sb.append('*');
			}
			sb.append('\n');
		}
		System.out.println(sb.toString());
	}

}
