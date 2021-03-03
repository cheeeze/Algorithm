import java.util.Scanner;

/*
 * BOJ #11721 열 개씩 끊어 출력하기
 * 시작일 : 2021-03-03
 * 완료일 : ``
 * 입출력, 구현
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		int len = input.length();
		int i = 0;
		while(i+10<len) {
			System.out.println(input.substring(i,i+10));
			i += 10;
		}
		System.out.println(input.substring(i,len));

	}

}
