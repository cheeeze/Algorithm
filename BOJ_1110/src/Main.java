import java.util.Scanner;

/*
 * BOJ #1110 더하기 사이클
 * 시작일 : 2020-07-21
 * 완료일 : ``
 * 구현
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int cnt = 1;
		int num = (n%10)*10+((n/10+n%10)%10);
		while(num!=n) {
			cnt++;
			num = (num%10)*10+((num/10+num%10)%10);
		}
		System.out.println(cnt);

	}

}
