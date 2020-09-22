import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
 * BOJ #11866 요세푸스 문제 0
 * 시작일 : 2020-09-22
 * 완료일 : ``
 * 구현
 */
public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		LinkedList<Integer> list = new LinkedList<>();
		for(int i=1;i<=n;i++) {
			list.add(i);
		}
		int i = 0;
		int idx = -1;
		LinkedList<Integer> answer = new LinkedList<>();
		while(i<n) {
			idx += k;
			while(idx>=list.size()) {
				idx %= list.size();
			}
			answer.add(list.remove(idx));
			i++;
			idx--;
		}

		StringBuilder sb = new StringBuilder();
		sb.append('<');
		for(i=0;i<n-1;i++) {
			sb.append(answer.get(i));
			sb.append(", ");
		}
		sb.append(answer.get(n-1));
		sb.append('>');

		System.out.println(sb.toString());
	}

}
