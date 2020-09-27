import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * BOJ #2884 알람 시계
 * 시작일 : 2020-09-27
 * 완료일 : ``
 * 구현
 */
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int hour = Integer.parseInt(st.nextToken());
		int min = Integer.parseInt(st.nextToken());
		min -= 45;
		if(min<0) {
			min += 60;
			hour--;
			if(hour<0) {
				hour += 24;
			}
		}
		System.out.println(hour+" "+min);
	}

}
