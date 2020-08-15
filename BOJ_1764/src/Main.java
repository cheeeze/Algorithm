import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
 * BOJ #1764 듣보잡
 * 시작일 : 2020-08-15
 * 완료일 : ``
 * 구현
 */
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		HashSet<String> set = new HashSet<>();
		for(int i=0;i<n;i++) {
			set.add(br.readLine());
		}		
		LinkedList<String> answer = new LinkedList<>();
		for(int i=0;i<m;i++) {
			String input = br.readLine();
			if(set.contains(input)) {
				answer.add(input);
			}
		}
		Collections.sort(answer);
		
		StringBuilder sb = new StringBuilder();
		sb.append(answer.size());
		sb.append('\n');
		Iterator<String> it = answer.iterator();
		while(it.hasNext()) {
			sb.append(it.next());
			sb.append('\n');
		}
		System.out.print(sb.toString());
	}

}
