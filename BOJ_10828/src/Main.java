import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * BOJ #10828 스택
 * 시작일 : 2020-08-24
 * 완료일 : ``
 * 스택
 */
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int top = -1;
		int[] stack = new int[10001];
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++) {
			String op = br.readLine();
			if(op.contains("push")) {
				int k = Integer.parseInt(op.substring(5));
				stack[++top] = k;
			}else if(op.equals("top")) {
				if(top==-1) {
					sb.append("-1\n");
				}else {
					sb.append(stack[top]);
					sb.append('\n');
				}				
			}else if(op.equals("pop")) {
				if(top==-1) {
					sb.append("-1\n");
				}else {
					sb.append(stack[top--]);
					sb.append('\n');
				}
			}else if(op.equals("size")) {
				sb.append(top+1);
				sb.append('\n');
			}else if(op.equals("empty")) {
				if(top==-1) {
					sb.append("1\n");
				}else {
					sb.append("0\n");
				}
			}
		}
		System.out.print(sb.toString());
	}

}
