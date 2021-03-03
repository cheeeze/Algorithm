import java.util.Scanner;

/*
 * BOJ #1924 2007년
 * 시작일 : 2021-03-03
 * 완료일 : ``
 * 구현
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		
		int[] month = {0,31,28,31,30,31,30,31,31,30,31,30,31};
		String[] day = {"SUN", "MON", "TUE", "WED","THU", "FRI", "SAT"};
		int dates = 0;
		for(int i=1;i<x;i++) {
			dates += month[i];
		}
		dates += y;
		System.out.println(day[dates%7]);

	}

}
