import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * BOJ #2920 음계
 * 시작일 : 2020-09-04
 * 완료일 : ``
 * 구현
 */
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		boolean asc = true;
		int prev = Integer.parseInt(st.nextToken());
		int num = Integer.parseInt(st.nextToken());
		if(num>prev) {
			asc = true;
		}else {
			asc = false;
		}
		boolean mix = false;		
		for(int i=0;i<6;i++) {
			prev = num;
			num = Integer.parseInt(st.nextToken());
			if(num>prev) {
				if(!asc) {
					mix = true;
					break;
				}
			}else {
				if(asc) {
					mix = true;
					break;
				}
			}
		}
		
		if(mix) {
			System.out.println("mixed");
		}else {
			if(asc) {
				System.out.println("ascending");
			}else {
				System.out.println("descending");
			}
		}
	}

}
