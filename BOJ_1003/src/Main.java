import java.util.Scanner;

/*
 * BOJ #1003 피보나치 함수
 * 시작일 : 2020-07-09
 * 완료일 : ``
 * DP, Memoization
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int[] mem0 = new int[41];
		int[] mem1 = new int[41];
		mem0[0] = 1;
		mem1[0] = 0;
		mem0[1] = 0;
		mem1[1] = 1;
		int end = 2;
		for(int tc=0; tc<t; tc++) {
			int n = sc.nextInt();
			if(n>1) {
				while(end <= n) {
					mem0[end] = mem0[end-1]+mem0[end-2];
					mem1[end] = mem1[end-1]+mem1[end-2];
					end++;
				}
			}
			System.out.println(mem0[n]+" "+mem1[n]);
		}
	}
}
