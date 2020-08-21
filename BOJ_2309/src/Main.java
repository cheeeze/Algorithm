import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * BOJ #2309 일곱 난쟁이
 * 시작일 : 2020-08-21
 * 완료일 : ``
 * 구현, 브루트포스
 */
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] n = new int[9];
		for(int i=0;i<9;i++) {
			n[i] = Integer.parseInt(br.readLine());
		}
		StringBuilder sb = new StringBuilder();
		Arrays.sort(n);
		int sum = 0;
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				if(i==j) {
					continue;
				}
				for(int k=0;k<9;k++) {		
					if(k==i || k==j) {
						continue;
					}
					sum+=n[k];
				}
				if(sum==100) {
					for(int k=0;k<9;k++) {
						if(k==i || k==j) {
							continue;
						}
						sb.append(n[k]);
						sb.append('\n');
					}
					System.out.print(sb.toString());
					return;
				}
				sum = 0;
			}
		}

	}

}
