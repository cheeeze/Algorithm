import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * BOJ #10819 차이를 최대로
 * 시작일 : 2020-07-23
 * 완료일 : ``
 * DFS
 */
public class Main {

	static int answer;
	static int[] num;
	static boolean[] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		num = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		visited = new boolean[n];
		answer = 0;
		int[] arr = new int[n];
		recur(arr, n, 0);
		System.out.println(answer);
	}
	
	static void recur(int[] arr, int n, int k) {
		if(k==n) {
			int sum = 0;
			int diff = 0;
			for(int i=0;i<n-1;i++) {
				diff = arr[i]-arr[i+1];
				if(diff<0) {
					diff *= -1;
				}
				sum += diff;
			}
			answer = Math.max(answer, sum);
			return;
		}
		
		for(int i=0;i<n;i++) {
			if(!visited[i]) {
				visited[i] = true;
				arr[k] = num[i];
				recur(arr,n,k+1);
				visited[i] = false;
			}
		}
		
	}

}
