import java.util.Arrays;
import java.util.Scanner;

/*
 * BOJ #10809 알파벳 찾기
 * 시작일 : 2020-10-19
 * 완료일 : ``
 * 구현
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		int n = s.length();
		int[] alpha = new int['z'-'a'+1];
		Arrays.fill(alpha, -1);
		for(int i=0;i<n;i++){
			char c = s.charAt(i);
			if(alpha[c-'a']==-1){
				alpha[c-'a']=i;
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<'z'-'a'+1;i++){
			sb.append(alpha[i]+" ");
		}
		System.out.println(sb.toString());

	}

}
