import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * BOJ #2750 수 정렬하기
 * 시작일 : 2020-07-17
 * 완료일 : ``
 * 정렬, Arrays 클래스 sort 메소드 활용
 */
public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++) {
			sb.append(arr[i]+"\n");
		}
		System.out.println(sb.toString());

	}

}
