import java.util.Scanner;

/*
 * BOJ #10844 쉬운 계단 수
 * 시작일 : 2021-03-06
 * 완료일 : ``
 * DP
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] num = new int[10];
		for(int i=1;i<10;i++) {
			num[i] = 1;
		}
		int[] newnum = new int[10];
		for(int i=1;i<n;i++) {
			newnum[0] = num[1]%1000000000;
			for(int j=1;j<9;j++) {
				newnum[j] = (num[j-1] + num[j+1])%1000000000;				
			}
			newnum[9] = num[8]%1000000000;
			for(int j=0;j<10;j++) {
				num[j] = newnum[j];
			}
		}
		int answer = 0;
		for(int i=0;i<10;i++) {
			answer += (num[i]%1000000000);
			answer %= 1000000000;
		}
		System.out.println(answer);

	}

}
