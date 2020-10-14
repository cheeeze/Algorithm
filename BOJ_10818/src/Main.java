import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * BOJ #10818 최소, 최대
 * 시작일 : 2020-10-14
 * 완료일 : ``
 * 구현
 */
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int min = 1000000;
		int max = -1000000;
		for(int i=0;i<n;i++){
			int x = Integer.parseInt(st.nextToken());
			if(min>x){
				min = x;
			}
			if(max<x){
				max = x;
			}
		}
		System.out.println(min+" "+max);

	}

}
