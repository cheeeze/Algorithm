import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;

/*
 * BOJ #2621 카드게임
 * 시작일 : 2020-07-18
 * 완료일 : 2020-08-04
 * 구현
 */
public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		char[] color = new char[5];
		int[] num = new int[5];
		int[] ccheck = new int[4];
		int[] ncheck = new int[10];
		for(int i=0;i<5;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			color[i] = st.nextToken().charAt(0);
			switch(color[i]) {
			case 'R':
				ccheck[0]++;
				break;
			case 'B':
				ccheck[1]++;
				break;
			case 'Y':
				ccheck[2]++;
				break;
			case 'G':
				ccheck[3]++;
				break;
			}
			num[i] = Integer.parseInt(st.nextToken());
			ncheck[num[i]]++;
		}
		int answer = 0;
		boolean stair = true;
		for(int i=1;i<=5;i++) {
			if(ncheck[i]==1) {
				for(int j=0;j<5;j++) {
					if(ncheck[i+j]==1) {
						stair = true;
					}else {
						stair = false;
						break;
					}
				}
			}else {
				stair = false;
			}
			if(stair) {
				break;
			}
		}
		if(stair) {
			int t = 0;
			for(int i=9;i>0;i--) {
				if(ncheck[i]>0) {
					t = i;
					break;
				}
			}
			if(ccheck[0]==5 || ccheck[1] ==5 || ccheck[2] ==5|| ccheck[3] ==5) {				
				answer = 900+t;
			}else {
				answer = Math.max(answer, 500+t);
			}
		}
		
		int nsame = 0;
		int samenum = 0;
		int oldnsame = 0;
		int oldsamenum = 0;
		for(int i=1;i<=9;i++) {
			if(ncheck[i]>=2) {
				oldnsame = nsame;
				oldsamenum = samenum;
				nsame = ncheck[i];
				samenum = i;
			}
		}
		if(nsame<oldnsame) {
			int t = oldnsame;
			oldnsame = nsame;
			nsame = t;
			t = oldsamenum;
			oldsamenum = samenum;
			samenum = t;
		}
		switch(nsame) {
		case 4:
			answer = Math.max(answer, 800+samenum);
			break;
		case 3:
			if(oldnsame == 2) {
				answer = Math.max(answer, 700+(samenum*10)+oldsamenum);
			}else {
				answer = Math.max(answer, 400+samenum);
			}
			break;
		case 2:
			if(oldnsame == 2) {
				answer = Math.max(answer, 300+(samenum*10)+oldsamenum);
			}else {
				answer = Math.max(answer, 200+samenum);
			}
			break;
		}
		int t = 0;
		for(int i=9;i>0;i--) {
			if(ncheck[i]>0) {
				t = i;
				break;
			}
		}
		if(ccheck[0]==5 || ccheck[1] ==5 || ccheck[2] ==5|| ccheck[3] ==5) {							
			answer = Math.max(answer, 600+t);
		}
		if(answer==0) {
			answer = 100+t;
		}
		System.out.println(answer);
	}

}
