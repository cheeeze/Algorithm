import java.util.Scanner;

/*
 * BOJ #2739 구구단
 * 시작일 : 2021-03-03
 * 완료일 : ``
 * 입출력, 구현
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i=1;i<=9;i++) {
			System.out.printf("%d * %d = %d\n",n,i,(n*i));
		}

	}

}
