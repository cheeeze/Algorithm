import java.util.LinkedList;
import java.util.Scanner;

/*
 * BOJ #1600 말이 되고픈 원숭이
 * 시작일 : 2020-02-03
 * 완료일 : 2020-02-08
 */
public class Main {
	static int[] hr = {-1,-2,-2,-1,1,2,2,1};
	static int[] hc = {-2,-1,1,2,2,1,-1,-2};
	static int[] mr = {1,-1,0,0};
	static int[] mc = {0,0,1,-1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		int w = sc.nextInt();//가로
		int h = sc.nextInt();//세로
		int[][] map = new int[h][w];
		for(int i=0;i<h;i++) {
			for(int j=0;j<w;j++) {
				map[i][j] = sc.nextInt();
			}
		}//입력완료
		if(h==1&&w==1) {
			System.out.println(0);
			return;
		}
		boolean[][][] visited = new boolean[h][w][31];
		int answer = Integer.MAX_VALUE;
		LinkedList<Move> q = new LinkedList<>();
		visited[0][0][0] = true;
		q.offer(new Move(0,0,0,0));
		while(!q.isEmpty()) {
			Move temp = q.poll();
			if(temp.horse<k) {//나이트 이동 가능
				for(int d=0;d<8;d++) {
					int tr = temp.r+hr[d];
					int tc = temp.c+hc[d];
					if(tr<0 || tc<0 || tr>=h || tc>=w || visited[tr][tc][temp.horse+1]) {
						continue;
					}
					if(map[tr][tc]==1) {
						continue;
					}
					if(tr==(h-1) && tc==(w-1)) {
						answer = Math.min(answer, temp.cnt+1);
					}else {
						visited[tr][tc][temp.horse+1] = true;
						q.offer(new Move(tr,tc,temp.horse+1,temp.cnt+1));
					}
				}
			}
			//원숭이 한칸이동
			for(int d=0;d<4;d++) {
				int tr= temp.r+mr[d];
				int tc = temp.c+mc[d];
				if(tr<0 || tc<0 || tr>=h || tc>=w || visited[tr][tc][temp.horse]) {
					continue;
				}
				if(map[tr][tc]==1) {
					continue;
				}
				if(tr==(h-1) && tc==(w-1)) {
					answer = Math.min(answer, temp.cnt+1);
				}else {
					visited[tr][tc][temp.horse] = true;
					q.offer(new Move(tr,tc,temp.horse,temp.cnt+1));
				}
				
			}
		}
		
		System.out.println(answer==Integer.MAX_VALUE?-1:answer);
	}
	
	static class Move{
		int r;
		int c;
		int horse;
		int cnt;
		
		public Move(int r, int c, int horse, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.horse = horse;
			this.cnt = cnt;
		}
	}
}