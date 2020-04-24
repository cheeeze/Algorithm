import java.util.Scanner;

/*
 * BOJ #5532 방학숙제
 * 시작일 : 2020-04-24
 * 완료일 : ``
 * 구현
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int l = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int d = sc.nextInt();
		int dif = 0;
		double temp1 = a/(double)c;
		double temp2 = b/(double)d;
		if(temp1>temp2) {
			dif = a/c;
			if(a%c!=0) {
				dif++;		
			}
		}else {
			dif = b/d;
			if(b%d!=0) {
				dif++;
			}
		}
		int answer = l-dif;
		System.out.println(answer);
	}

}
