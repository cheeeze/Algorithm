import java.util.ArrayList;
import java.util.Scanner;

/*
 * BOJ #1644 소수의 연속합
 * 시작일 : 2020-09-13
 * 완료일 : ``
 * 에라토스테네스의 체, 투 포인터
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] num = new int[n+1];
		ArrayList<Integer> prime = new ArrayList<>();
		for(int i=2;i<=n;i++) {
			num[i] = i;
		}
		for(int i=2;i<=n;i++) {
			if(num[i]==0) {
				continue;
			}
			prime.add(i);
			for(int j=i*2;j<=n;j+=i) {
				num[j] = 0;
			}
		}
		
		int left = 0;
		int right = 0;
		int size = prime.size();
		int sum = 0;
		int answer = 0;
		while(left<=right) {
			if(sum<n) {
				if(right>=size) {
					break;
				}
				sum+=prime.get(right++);
			}else if(sum>n) {
				sum-=prime.get(left++);
			}else {
				answer++;
				sum-=prime.get(left++);
			}
		}
		System.out.println(answer);
	}

}
