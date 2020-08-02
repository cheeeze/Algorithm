import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * BOJ #1759 암호 만들기
 * 시작일 : 2020-08-02
 * 완료일 : ``
 * 백트래킹
 */
public class Main {

	static char[] word;
	static boolean[] visited;
	static StringBuilder sb;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int l = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		word = new char[c];
		visited = new boolean[c];
		for(int i=0;i<c;i++) {
			word[i] = st.nextToken().charAt(0);
		}
		char[] words = new char[l];
		sb = new StringBuilder();
		Arrays.sort(word);
		recur(words,0,l,c);
		System.out.print(sb.toString());
	}

	static void recur(char[] words, int k, int n, int m) {
		if(k>1) {
			if(words[k-2]>=words[k-1]) {
				return;
			}
		}
		if(k==n) {
			boolean check = false;
			int cnt = 0;
			for(int i=0;i<n;i++) {
				if(words[i]=='a' || words[i]=='e' || words[i]=='i' || words[i]=='o' || words[i] == 'u') {
					check = true;
				}else {
					cnt++;
				}
			}
			if(check && cnt>=2) {
				sb.append(words);
				sb.append('\n');
			}
			return;
		}
		for(int i=k;i<m;i++) {
			if(!visited[i]) {
				visited[i] = true;
				words[k] = word[i];
				recur(words,k+1,n,m);
				visited[i] = false;
			}
		}
	}
}
