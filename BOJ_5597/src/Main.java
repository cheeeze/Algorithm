import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * BOJ #5597 과제 안 내신 분..?
 * 시작일 : 2020-09-17
 * 완료일 : ``
 * 구현
 */
public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean[] check = new boolean[31];
		for(int i=0;i<28;i++) {
			int k = Integer.parseInt(br.readLine());
			check[k] =  true;
		}
		
		for(int i=1;i<=30;i++) {
			if(!check[i]) {
				System.out.println(i);
			}
		}

	}

}
