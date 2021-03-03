import java.util.Scanner;

/*
 * BOJ #8393 합
 * 시작일 : 2021-03-03
 * 완료일 : ``
 * 구현
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int sum = 0;
		for(int i=1;i<=n;i++) {
			sum += i;
		}
		System.out.println(sum);

	}

}
