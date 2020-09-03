import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * BOJ #1316 그룹 단어 체커
 * 시작일 : 2020-09-03
 * 완료일 : ``
 * 구현
 */
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int answer = n;
		for(int i=0;i<n;i++) {
			String s = br.readLine();
			int len = s.length();
			boolean[] checked = new boolean[26];
			char prev = s.charAt(0);
			checked[s.charAt(0)-'a'] = true;
			for(int j=1;j<len;j++) {
				if(s.charAt(j)!=prev) {
					if(checked[s.charAt(j)-'a']) {
						answer--;
						break;
					}else {
						checked[s.charAt(j)-'a'] = true;
						prev = s.charAt(j);
					}
				}
			}
		}
		System.out.println(answer);
	}

}
