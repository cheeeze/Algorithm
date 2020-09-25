import java.util.Scanner;

/*
 * BOJ #2741 N 찍기
 * 시작일 : 2020-09-25
 * 완료일 : ``
 * 구현
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<=n;i++) {
			sb.append(i);
			sb.append('\n');
		}
		System.out.print(sb.toString());
	}

}
