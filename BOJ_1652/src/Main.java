import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * BOJ #1652 누울 자리를 찾아라
 * 시작일 : 2020-07-14
 * 완료일 : ``
 * 구현
 */
public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		char[][] map = new char[n][n];
		for(int i=0;i<n;i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		int r = 0;
		int c = 0;
		for(int i=0;i<n;i++) {
			int cnt = 0;
			for(int j=0;j<n;j++) {
				if(map[i][j]=='X') {
					if(cnt>1) {
						r++;
					}
					cnt = 0;
				}else {
					cnt++;
				}
			}
			if(cnt>1) {
				r++;
			}
			cnt = 0;
			for(int j=0;j<n;j++) {
				if(map[j][i]=='X') {
					if(cnt>1) {
						c++;
					}
					cnt = 0;
				}else {
					cnt++;
				}
			}
			if(cnt>1) {
				c++;
			}
		}
		
		System.out.println(r+" "+c);
	}

}
