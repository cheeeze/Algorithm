import java.util.Scanner;

/*
 * BOJ #2011 암호코드
 * 시작일 : 2021-03-11
 * 완료일 : ``
 * DP
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		int len = input.length();
		int[] array = new int[len+1];
		for(int i=0;i<len;i++) {
			array[i+1] = input.charAt(i)-'0';
		}
		
		int[] dp = new int[len+1];
		dp[0] = 1;
		
		for(int i=1;i<=len;i++) {
			if(array[i]!=0) {
				dp[i] = (dp[i]+dp[i-1])%1000000;
			}
			
			int x = array[i]+array[i-1]*10;
			if(x>=10 && x<=26) {
				dp[i] = (dp[i]+dp[i-2])%1000000;
			}
		}
		
		System.out.println(dp[len]);

	}
	
}
