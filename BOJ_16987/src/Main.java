import java.util.ArrayList;
import java.util.Scanner;

/*
 * BOJ #16987 계란으로 계란치기
 * 시작일 : 2020-02-06
 * 완료일 : ``
 */
public class Main {
	static int answer = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Egg[] egg = new Egg[n];
		for(int i=0;i<n;i++) {
			egg[i] = new Egg(sc.nextInt(),sc.nextInt());
		}
		
		if(n==1) {
			System.out.println(answer);
			return;
		}
		
		dfs(0,n,egg);
		System.out.println(answer);

	}
	
	static void dfs(int x, int n, Egg[] egg) {
		if(x==n) {
			int sum = 0;
			for(int i=0;i<n;i++) {
				if(egg[i].s<=0) {
					sum++;
				}
			}
			answer = Math.max(answer,sum);
			return;
		}
		
		if(egg[x].s<=0) {
			dfs(x+1,n,egg);
		}else {
			
		for(int i=0;i<n;i++) {
			if(i==x) continue;
			if(egg[i].s<=0) continue;
			egg[i].s-=egg[x].w;
			egg[x].s-=egg[i].w;
			dfs(x+1,n,egg);
			egg[i].s+=egg[x].w;
			egg[x].s+=egg[i].w;	
		}
		}
		
		if(x==n-1) {
			int sum = 0;
			for(int i=0;i<n;i++) {
				if(egg[i].s<=0) {
					sum++;
				}
			}
			answer = Math.max(answer,sum);
			return;
		}
		
	}
	
	static class Egg{
		int s;
		int w;
		
		public Egg(int s, int w) {
			super();
			this.s = s;
			this.w = w;
		}
	}

}
