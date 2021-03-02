import java.util.Scanner;

/*
 * BOJ #10952 A+B - 5
 * 시작일 : 2021-03-02
 * 완료일 : ``
 * 입출력, 구현
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			if(a==0 && b==0) {
				break;
			}
			System.out.println(a+b);
		}

	}

}
