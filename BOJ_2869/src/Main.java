import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * BOJ #2869 달팽이는 올라가고 싶다
 * 시작일 : 2020-10-11
 * 완료일 : ``
 * 수학
 */
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());
		v -= b;
		int answer = 0;
		answer = v/(a-b);
		if(v%(a-b)!=0){
			answer++;
		}
		System.out.println(answer);
	}

}
