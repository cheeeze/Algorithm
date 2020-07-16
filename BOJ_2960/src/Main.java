import java.util.Scanner;

/*
 * BOJ #2960 에라토스테네스의 체
 * 시작일 : 2020-07-16
 * 완료일 : ``
 * 에라토스테네스의 체
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] num = new int[1001];
		for(int i=2;i<=n;i++) {
			num[i] = i;
		}
		int cnt = 0;
		int answer = 0;
		Loop : for(int i=2;i<=n;i++) {
			if(num[i]==0) {
				continue;
			}
			
			for(int j=i;j<=n;j+=i) {
				if(num[j]==0) {
					continue;
				}
				num[j] = 0;
				cnt++;
				if(cnt==k) {
					answer = j;
					break Loop;
				}
			}
		}
		System.out.println(answer);
	}

}
