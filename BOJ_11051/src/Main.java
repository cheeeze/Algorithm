import java.util.Scanner;

/*
 * BOJ #11051 이항 계수 2
 * 시작일 : 2020-08-09
 * 완료일 : ``
 * 메모이제이션
 */
public class Main {

	static long[][] mem;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		mem = new long[n+1][n+1];
		System.out.println(comb(n,k));
	}
	
	static long comb(int n, int k) {
		if(mem[n][k]>0) {
			return mem[n][k];
		}
		if(k==0 || n==k) {
			return mem[n][k] = 1;
		}
		
		return mem[n][k] = (comb(n-1,k-1)+comb(n-1,k))%10007;
	}

}
