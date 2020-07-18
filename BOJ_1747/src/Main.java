import java.util.Scanner;

/*
 * BOJ #1747 소수&팰린드롬
 * 시작일 : 2020-07-18
 * 완료일 : ``
 * 소수(에라토스테네스의 체)
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] num = new int[1003002];
		for(int i=2;i<1003002;i++) {
			num[i] = i;
		}
		
		for(int i=2;i<1003002;i++) {			
			if(num[i]==0) {
				continue;
			}
			//팰린드롬 check
			if(i>=n) {
				int p = 0;
				int temp = i;
				while(temp>0) {
					p *= 10;
					p += temp%10;
					temp /= 10;
				}

				if(p==i) {
					System.out.println(i);
					break;
				}
			}			
			for(int j=i;j<1003002;j+=i) {
				num[j] = 0;
			}
		}

	}

}
