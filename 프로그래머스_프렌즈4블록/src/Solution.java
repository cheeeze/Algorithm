import java.util.LinkedList;

/*
 * 프로그래머스 [1차] 프렌즈4블록
 * 2018 KAKAO BLIND RECRUITMENT
 * 시작일 : 2020-09-02
 * 완료일 : ``
 * 구현
 */
public class Solution {

	static int[] dr = {0,1,1};
	static int[] dc = {1,0,1};
	
	public static void main(String[] args) {
		String[] b = {"CCBDE", "AAADE", "AAABF", "CCBBF"};
		System.out.println(solution(4,5,b));
		String[] bb = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};
		System.out.println(solution(6,6,bb));

	}
	
	public static int solution(int m, int n, String[] board) {
        int answer = 0;
        boolean check = true;
        boolean[][] visited = new boolean[m][n];
        char[][] map = new char[m][n];
        for(int i=0;i<m;i++) {
        	for(int j=0;j<n;j++) {
        		map[i][j] = board[i].charAt(j);
        	}
        }
        while(check) {
        	check = false;
        	visited = new boolean[m][n];
        	
        	for(int i=0;i<m-1;i++) {
        		for(int j=0;j<n-1;j++) {
        			if(map[i][j]==' ') {
        				continue;
        			}
        			if(pang(map,visited,i,j)) {
        				check = true;
        			}
        		}
        	}
        	for(int j=0;j<n;j++) {
        		LinkedList<Character> q = new LinkedList<>();
        		for(int i=m-1;i>=0;i--) {
        			if(!visited[i][j]) {
        				q.offer(map[i][j]);
        			}
        		}
        		int cnt = m-1;
        		while(cnt>=0) {
        			if(!q.isEmpty()) {
        				map[cnt][j] = q.poll();
        			}else {
        				map[cnt][j] = ' ';
        			}
        			cnt--;
        		}
        	}
        }
        for(int i=0;i<m;i++) {
        	for(int j=0;j<n;j++) {
        		if(map[i][j]==' ') {
        			answer++;
        		}
        	}
        }
        return answer;
    }
	
	public static boolean pang(char[][] board, boolean[][] visited, int r, int c) {
		boolean answer = true;
		char alpha = board[r][c];
		for(int d=0;d<3;d++) {
			int tr = r+dr[d];
			int tc = c+dc[d];
			if(alpha!=board[tr][tc]) {
				answer = false;
				break;
			}
		}
		if(answer) {
			visited[r][c] = true;
			for(int d=0;d<3;d++) {
				int tr = r+dr[d];
				int tc = c+dc[d];
				visited[tr][tc] = true;				
			}
		}
		return answer;
	}

}
