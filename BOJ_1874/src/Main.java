import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/*
 * BOJ #1874 스택 수열
 * 시작일 : 2020-10-15
 * 완료일 : 2020-10-16
 * 스택
 */
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		Stack<Integer> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		int num = 1;
		for(int i=0;i<n;i++){
			int x = Integer.parseInt(br.readLine());
			if(stack.isEmpty()){
				sb.append("+\n");
				stack.push(num++);
			}
			while(stack.peek()!=x && num<=n){;
				sb.append("+\n");
				stack.push(num++);
			}
			if(stack.peek()==x){
				sb.append("-\n");
				stack.pop();
			}else{
				System.out.println("NO");
				return;
			}
		}
		System.out.print(sb.toString());
		
	}

}
