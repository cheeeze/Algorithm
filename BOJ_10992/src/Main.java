import java.util.Scanner;

/*
 * BOJ #10992 별 찍기 - 17
 * 시작일 : 2021-03-04
 * 완료일 : ``
 * 구현
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n-1;i++) {
			for(int j=1;j<n-i;j++) {
				sb.append(' ');
			}
			sb.append('*');
			for(int j=0;j<(i*2)-1;j++) {
				sb.append(" ");
			}
			if(i>0) {
				sb.append('*');
			}
			
			sb.append('\n');
		}
		for(int i=0;i<(2*n)-1;i++) {
			sb.append('*');
		}
		System.out.println(sb.toString());

	}

}
