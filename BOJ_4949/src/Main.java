import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/*
 * BOJ #4949 균형잡힌 세상
 * 시작일 : 2020-09-20
 * 완료일 : ``
 * 스택
 */
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = null;
		StringBuilder sb = new StringBuilder();
		while(!(input=br.readLine()).equals(".")) {
			int len = input.length();
			Stack<Character> stack = new Stack<>();
			boolean answer = true;
			for(int i=0;i<len;i++) {
				char c = input.charAt(i);
				if(c=='(') {
					stack.push(c);
				}else if(c==')') {
					if(stack.isEmpty()) {
						answer = false;
						break;
					}else if(stack.peek()=='(') {
						stack.pop();
					}else {
						answer = false;
						break;
					}
				}else if(c=='[') {
					stack.push('[');
				}else if(c==']') {
					if(stack.isEmpty()) {
						answer = false;
						break;
					}else if(stack.peek()=='[') {
						stack.pop();
					}else {
						answer = false;
						break;
					}
				}
			}
			if(!stack.isEmpty()) {
				answer = false;
			}
			if(answer) {
				sb.append("yes\n");
			}else {
				sb.append("no\n");
			}
		}
		System.out.print(sb.toString());
	}

}
