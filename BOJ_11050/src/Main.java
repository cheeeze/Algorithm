import java.util.Scanner;

/*
 * BOJ #11050 이항 계수 1
 * 시작일 : 2020-08-09
 * 완료일 : ``
 * 재귀
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		System.out.println(comb(n,k));
	}
	
	static int comb(int n, int k) {
		if(k==0 || n==k) {
			return 1;
		}
		return comb(n-1,k-1)+comb(n-1,k);
	}

}
