import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/*
 * BOJ #9012 괄호
 * 시작일 : 2020-08-16
 * 완료일 : ``
 * 스택
 */
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++) {
			Stack<Integer> stack = new Stack<>();
			String input = br.readLine();
			int len = input.length();
			boolean answer = true;
			for(int j=0;j<len;j++) {
				if(input.charAt(j)=='(') {
					stack.push(1);
				}else {
					if(stack.isEmpty()) {
						sb.append("NO\n");
						answer = false;
						break;
					}else {
						stack.pop();
					}
				}
			}
			if(answer) {
				if(stack.isEmpty()) {
					sb.append("YES\n");
				}else {
					sb.append("NO\n");
				}
			}
			
		}
		System.out.print(sb.toString());
	}

}
