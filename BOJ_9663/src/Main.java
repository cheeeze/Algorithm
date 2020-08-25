import java.util.Scanner;

/*
 * BOJ #9663 N-Queen
 * 시작일 : 2020-08-06
 * 완료일 : 2020-08-25
 * 백트래킹
 */
public class Main {

	static int N;
	static int answer;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] q = new int[n];
		N = n;
		answer = 0;
		nq(0,q);
		System.out.println(answer);
	}
	
	
	static boolean isPromiss(int[] q, int n) {
		for(int i=0;i<n;i++) {
			if(q[n]==q[i]) {
				return false;
			}
			if(Math.abs(n-i)==Math.abs(q[n]-q[i])) {
				return false;
			}
		}
		return true;
	}
		
	
	static void nq(int k, int[] q) {
		if(k==N) {
			answer++;
			return;
		}
		for(int i=0;i<N;i++) {
			q[k] = i;			
			if(isPromiss(q,k)) {
				nq(k+1,q);
			}
		}
	}
	
}
