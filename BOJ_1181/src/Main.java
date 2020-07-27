import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

/*
 * BOJ #1181 단어 정렬
 * 시작일 : 2020-07-27
 * 완료일 : ``
 * 정렬
 * 시간 : 1836ms 오래 걸리는 이유는?
 */
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		LinkedList<String> list = new LinkedList<>();
		for(int i=0;i<n;i++) {
			String word = br.readLine();
			if(!list.contains(word)) {
				list.add(word);
			}			
		}
		
		Collections.sort(list, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				if(o1.length()==o2.length()) {
					return o1.compareTo(o2);
				}
				return o1.length()-o2.length();
			}
			
		});
		
		StringBuilder sb = new StringBuilder();
		Iterator<String> it = list.iterator();
		while(it.hasNext()) {
			sb.append(it.next());
			sb.append('\n');
		}
		System.out.println(sb);
	}

}
