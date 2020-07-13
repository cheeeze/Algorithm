import java.util.Stack;

/*
 * 프로그래머스 괄호 변환
 * 2020 KAKAO BLIND RECRUITMENT
 * 시작일 : 2020-07-13
 * 완료일 : ``
 * 구현
 */
public class Solution {

	public static void main(String[] args) {
		System.out.println(solution("(()())()"));
		System.out.println("=====");
		System.out.println(solution(")("));
		System.out.println("=====");
		System.out.println(solution("()))((()"));
		
		System.out.println("======");
		System.out.println(solution("))()))(((("));
	
	}

	public static String solution(String p) {       
        if(correct(p)) {
        	return p;
        }
        return func(p);
    }
	
	static String func(String p) {
		//divide
		int len = p.length();
		if(len==0) {
			return "";
		}
		int cnt = 0;
		String u = "";
		String v = "";
		for(int i=0;i<len;i++) {
			if(p.charAt(i)=='(') {
				cnt++;
			}else {
				cnt--;
			}
			
			if(cnt==0) {
				u = p.substring(0, i+1);
				v = p.substring(i+1);
				break;
			}
		}

		if(correct(u)) {
			return u+func(v);
		}else {
			StringBuilder sb = new StringBuilder();
			sb.append('(');
			sb.append(func(v));
			sb.append(')');
			
			u = u.substring(1,u.length()-1);
			int ulen = u.length();
			
			for(int i=0;i<ulen;i++) {
				if(u.charAt(i)=='(') {
					sb.append(')');
				}else {
					sb.append('(');
				}
			}
			return sb.toString();			
		}
	}
	
	static boolean correct(String p) {
		Stack<Integer> stack = new Stack<>();
		int len = p.length();
		for(int i=0;i<len;i++) {
			if(p.charAt(i)=='(') {
				stack.push(1);
			}else {
				if(stack.isEmpty()) {
					return false;
				}else {
					stack.pop();
				}
			}
		}
		
		if(!stack.isEmpty()) {
			return false;
		}
		return true;
	}
}
