import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
 * BOJ #2816 디지털 티비
 * 시작일 : 2020-08-22
 * 완료일 : ``
 * 구현
 */
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int ch1 = 0;
		int ch2 = 0;
		ArrayList<String> list = new ArrayList<>();
		for(int i=0;i<n;i++) {
			String ch = br.readLine();
			if(ch.equals("KBS1")) {
				ch1 = i;
			}else if(ch.equals("KBS2")) {
				ch2 = i;
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<ch1;i++) {
			sb.append(1);
		}
		for(int i=0;i<ch1;i++) {
			sb.append(4);
		}
		if(ch1>ch2) {
			ch2++;
		}
		for(int i=0;i<ch2;i++) {
			sb.append(1);
		}
		for(int i=1;i<ch2;i++) {
			sb.append(4);
		}
		System.out.println(sb.toString());
	}

}
