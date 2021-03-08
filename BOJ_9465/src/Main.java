import java.util.Scanner;

/*
 * BOJ #9465 스티커
 * 시작일 : 2021-03-08
 * 완료일 : ``
 * DP
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i=0;i<t;i++) {
			int n = sc.nextInt();
			int[][] sticker = new int[2][n+2];
			for(int r=0;r<2;r++) {
				for(int c=1;c<=n;c++) {
					sticker[r][c] = sc.nextInt();
				}
			}
			
			int[][] answer = new int[2][n+2];
			answer[0][1] = sticker[0][1];
			answer[1][1] = sticker[1][1];
			
			for(int c=2;c<n+2;c++) {
				for(int r=0;r<2;r++) {
					int max = answer[r][c-2];
					max = Integer.max(max, answer[(r+1)%2][c-2]);
					max = Integer.max(max, answer[(r+1)%2][c-1]);
					answer[r][c] = max+sticker[r][c];
				}
			}
			
			int max = -1;
			
			for(int r=0;r<2;r++) {
				for(int c=n;c<n+2;c++) {
					max = Integer.max(max, answer[r][c]);
				}
			}
			
			System.out.println(max);
			
		}

	}

}
