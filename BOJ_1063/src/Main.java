import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * BOJ #1063 킹
 * 시작일 : 2020-09-05
 * 완료일 : ``
 * 시뮬레이션
 */
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String king = st.nextToken();
		String stone = st.nextToken();
		int r = king.charAt(1)-'0';
		char c = king.charAt(0);
		int sr = stone.charAt(1)-'0';
		char sc = stone.charAt(0);
		
		int n = Integer.parseInt(st.nextToken());
		for(int i=0;i<n;i++) {
			String move = br.readLine();
			switch(move) {
			case "R":
				if(c<'H') {
					c++;
					if(sc==c && sr==r) {
						if(sc<'H') {
							sc++;
						}else {
							c--;
						}
					}
				}				
				break;
			case "L":
				if(c>'A') {
					c--;
					if(sc==c && sr==r) {
						if(sc>'A') {
							sc--;
						}else {
							c++;
						}
					}
				}				
				break;
			case "T":
				if(r<8) {
					r++;
					if(sc==c && sr==r) {
						if(sr<8) {
							sr++;
						}else {
							r--;
						}
					}
				}				
				break;
			case "B":
				if(r>1) {
					r--;
					if(sc==c && sr==r) {
						if(sr>1) {
							sr--;
						}else {
							r++;
						}
					}
				}				
				break;
			case "RB":
				if(c<'H' && r>1) {
					c++;
					r--;
					if(sc==c && sr==r) {
						if(sc<'H' && sr>1) {
							sc++;
							sr--;
						}else {
							c--;
							r++;
						}
					}
				}				
				break;
			case "LB":
				if(c>'A' && r>1) {
					c--;
					r--;
					if(sc==c && sr==r) {
						if(sc>'A' && sr>1) {
							sc--;
							sr--;
						}else {
							c++;
							r++;
						}
					}
				}				
				break;
			case "RT":
				if(c<'H' && r<8) {
					c++;
					r++;
					if(sc==c && sr==r) {
						if(sc<'H' && sr<8) {
							sc++;
							sr++;
						}else {
							c--;
							r--;
						}
					}
				}				
				break;
			case "LT":
				if(c>'A' && r<8) {
					c--;
					r++;
					if(sc==c && sr==r) {
						if(sc>'A' && sr<8) {
							sc--;
							sr++;
						}else {
							c++;
							r--;
						}
					}
				}				
				break;
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(c);
		sb.append(r);
		sb.append('\n');
		sb.append(sc);
		sb.append(sr);
		System.out.println(sb.toString());
	}

}
