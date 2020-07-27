import java.util.Scanner;

/*
 * BOJ #2742 기찍 N
 * 시작일 : 2020-07-28
 * 완료일 : ``
 * 출력
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for(int i=n;i>0;i--) {
			sb.append(i);
			sb.append('\n');
		}
		System.out.println(sb.toString());
	}

}
