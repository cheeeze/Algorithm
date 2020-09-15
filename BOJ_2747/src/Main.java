import java.util.Scanner;

/*
 * BOJ #2747 피보나치 수
 * 시작일 : 2020-09-15
 * 완료일 : ``
 * 수학, 메모이제이션
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] fibo = new int[n+1];
		if(n<=1) {
			System.out.println(n);
			return;
		}
		fibo[0] = 0;
		fibo[1] = 1;
		for(int i=2;i<=n;i++) {
			fibo[i] = fibo[i-1]+fibo[i-2];
		}
		System.out.println(fibo[n]);
	}

}
