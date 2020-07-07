import java.util.Scanner;

/*
 * BOJ #1085 직사각형에서 탈출
 * 시작일 : 2020-07-07
 * 완료일 : ``
 * 수학, 구현
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		int w = sc.nextInt();
		int h = sc.nextInt();
		
		int answer = Math.min(x, w-x);
		answer = Math.min(answer, y);
		answer = Math.min(answer, h-y);

		System.out.println(answer);
	}

}
