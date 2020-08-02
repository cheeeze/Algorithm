import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * BOJ #2075 N번째 큰 수
 * 시작일 : 2020-08-02
 * 완료일 : ``
 * 슬라이딩 윈도우
 */
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] map = new int[n][n];
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[] p = new int[n];
		Arrays.fill(p, n-1);
		int max = 0;
		int answer = 0;
		int cur = 0;
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(max<=map[p[j]][j]) {
					max = map[p[j]][j];
					cur = j;
				}
			}
			p[cur]--;
			answer = max;
			max = 0;
		}
		
		System.out.println(answer);

	}

}
