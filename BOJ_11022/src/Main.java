import java.util.Scanner;

/*
 * BOJ #11022 A+B - 8
 * 시작일 : 2021-03-03
 * 완료일 : ``
 * 입출력, 구현
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i=1;i<=t;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			System.out.println("Case #"+i+": "+a+" + "+b+" = "+(a+b));
		}

	}

}
