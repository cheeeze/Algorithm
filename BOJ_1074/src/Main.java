import java.util.Scanner;

/*
 * BOJ #1074 Z
 * 시작일 : 2020-07-11
 * 완료일 : ``
 * 분할정복
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int r = sc.nextInt();
		int c = sc.nextInt();
		int side = 1<<n;
		divide(0,0,side,side,r,c,n,0);

	}
	
	static void divide(int startr, int startc, int endr, int endc, int r, int c, int n, int answer) {
		if(n==0) {
			System.out.println(answer);
			return;
		}

		int midr = (startr+endr)/2;
		int midc = (startc+endc)/2;

		if(r>=startr && r<midr && c>=startc && c<midc) { //4사분면		
			endr = midr;
			endc = midc;			
		}else if(r>=startr && r<midr && c<endc && c>=midc) { //1사분면			
			answer = answer+(1<<(n-1)*2);
			endr = midr;
			startc = midc;			
		}else if(r>=midr && r<endr && c>=midc && c<endc) { //2사분면		
			answer = answer+(1<<(n-1)*2)*3;
			startr = midr;
			startc = midc;			
		}else if(r>=midr && r<endr && c>= startc && c<midc) { //3사분면			
			answer = answer+(1<<(n-1)*2)*2;
			startr = midr;
			endc = midc;		
		}	
		
		n--;
		divide(startr, startc, endr,endc,r,c,n,answer);
	}

}
