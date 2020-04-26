import java.util.Scanner;

/*
 * BOJ #2455 지능형 기차
 * 시작일 : 2020-04-26
 * 완료일 : ``
 * 구현
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		int[] in = new int[4];
		int[] out = new int[4];
		for(int i=0;i<4;i++) {
			out[i] = sc.nextInt();
			in[i] = sc.nextInt();
		}
		int all = 0;
		int max = 0;
		for(int i=0;i<4;i++) {
			all = all+in[i]-out[i];
			max = Math.max(all, max);
		}
		System.out.println(max);

	}

}
