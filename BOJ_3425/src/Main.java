import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
 * BOJ #3425 고스택
 * 시작일 : 2020-08-15
 * 완료일 : 2020-08-17
 * 구현, 스택
 */
public class Main {
	
	static int INF = 1000000000;
	static int top = -1;
	static int[] arr = new int[1001];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		ArrayList<String> cmd = new ArrayList<>();
		while(true) {
			String input = br.readLine();
			if(input.equals("QUIT")) {
				break;
			}else if(input.equals("END")) {
				//숫자 입력 시작
				int n = Integer.parseInt(br.readLine());
				for(int i=0;i<n;i++) {
					top = -1;
					int num = Integer.parseInt(br.readLine());
					num(num);
					int size = cmd.size();
					boolean status = true;
					for(int j=0;j<size;j++) {
						String command = cmd.get(j);
						if(command.contains("NUM")) {
							int num2 = Integer.parseInt(command.substring(4));
							num(num2);
						}
						switch(command) {
						case "POP":
							status = pop();
							break;
						case "INV":
							status = inv();
							break;
						case "DUP":
							status = dup();
							break;
						case "SWP":
							status = swp();
							break;
						case "ADD":
							status = add();
							break;
						case "SUB":
							status = sub();
							break;
						case "MUL":
							status = mul();
							break;
						case "DIV":
							status = div();
							break;
						case "MOD":
							status = mod();
							break;
						}
						if(!status) {
							sb.append("ERROR\n");
							break;
						}
					}
					if(status) {
						if(top==0) {
							sb.append(arr[top]);
							sb.append("\n");
						}else {
							sb.append("ERROR\n");
						}
					}
				}
			}else if(input.length()==0) {
				cmd.clear();
				sb.append('\n');
			}else {
				cmd.add(input);
			}
		}
		System.out.print(sb.toString());

	}
	
	static void num(int x) {
		++top;
		arr[top] = x;
	}
	
	static boolean pop() {
		if(top<0) {
			return false;
		}
		top--;
		return true;
	}
	
	static boolean inv() {
		if(top<0) {
			return false;
		}
		arr[top] *= -1;
		return true;
	}

	static boolean dup() {
		if(top<0) {
			return false;
		}
		num(arr[top]);
		return true;
	}
	
	static boolean swp() {
		if(top<1) {
			return false;
		}
		int t1 = arr[top];
		int t2 = arr[top-1];
		arr[top-1] = t1;
		arr[top] = t2;
		return true;
	}
	
	static boolean add() {
		if(top<1) {
			return false;
		}
		int t = arr[top];
		pop();
		if((t>0 && (INF-t<arr[top])) || (t<0 && (arr[top] < (INF*-1)-t))) {
			return false;
		}
		arr[top] += t;
		return true;
	}
	
	static boolean sub() {
		if(top<1) {
			return false;
		}
		int t = arr[top];
		pop();
		if((t>0 && INF-t<Math.abs(arr[top])) || (t<0 && INF+t<Math.abs(arr[top]))) {
			return false;
		}
		arr[top] -= t;
		return true;
	}
	
	static boolean mul() {
		if(top<1) {
			return false;
		}
		int t = arr[top];
		pop();
		if(t>0 && INF/t<arr[top]) {
			return false;
		}else if(t<0 && INF/t*-1<arr[top]) {
			return false;
		}
		arr[top] *= t;
		return true;
	}
	
	static boolean div() {
		if(top<1) {
			return false;
		}
		int t = arr[top];
		if(t==0) {
			return false;
		}
		pop();
		arr[top] /= t;
		return true;
	}
	
	static boolean mod() {
		if(top<1) {
			return false;
		}
		int t = arr[top];
		if(t==0) {
			return false;
		}
		pop();
		arr[top] %= t;
		return true;
	}

}
