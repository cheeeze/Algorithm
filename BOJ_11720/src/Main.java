import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * BOJ #11720 숫자의 합
 * 시작일 : 2020-10-05
 * 완료일 : ``
 * 구현
 */
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String input = br.readLine();
		int sum = 0;
		for(int i=0;i<n;i++) {
			sum+=input.charAt(i)-'0';
		}
		System.out.println(sum);
	}

}
