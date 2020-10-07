import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * BOJ #4344 평균은 넘겠지
 * 시작일 : 2020-10-07
 * 완료일 : ``
 * 구현, 출력
 */
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
		for(int tc=0;tc<testcase;tc++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int[] score = new int[n];
			int sum = 0;
			double avg = 0.0;
			double count = 0;
			for(int i=0;i<n;i++){
				score[i] = Integer.parseInt(st.nextToken());
				sum += score[i];
			}
			avg = sum/(double)n;
			for(int i=0;i<n;i++){
				if(avg<score[i]){
					count++;
				}
			}
			double answer = count/n*100;
			System.out.printf("%.3f%%\n",answer);
		}

	}

}
