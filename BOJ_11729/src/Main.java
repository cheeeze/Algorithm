import java.util.Scanner;

/*
 * BOJ #11729 하노이 탑 이동 순서
 * 시작일 : 2020-09-06
 * 완료일 : ``
 * 재귀
 */
public class Main {
	
	static StringBuilder sb;
	static int cnt;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sb = new StringBuilder();
		cnt = 0;
		move(n,1,2,3);
		System.out.println(cnt);
		System.out.print(sb.toString());
	}
	
	static void move(int n, int a, int b, int c) {
		if(n==1) {
			cnt++;
			sb.append(a+" "+c+'\n');
		}else {
			move(n-1,a,c,b);
			move(1,a,b,c);
			move(n-1,b,a,c);
		}
	}

}
