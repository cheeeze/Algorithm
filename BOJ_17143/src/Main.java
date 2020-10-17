import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

/*
 * BOJ #17143 낚시왕
 * 시작일 : 2020-10-17
 * 완료일 : 2020-10-18
 * 시뮬레이션
 */
public class Main {

	static int R;
	static int C;
	static ArrayList<Shark> shark;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		shark = new ArrayList<>();
		shark.add(new Shark(0,0,0,0,0,0));
		ArrayList<Integer>[][] sea = new ArrayList[R+1][C+1];
		init(sea);
		int[][] map = new int[R][C];
		for(int i=1;i<=m;i++){
			st = new StringTokenizer(br.readLine());
			//r,c,속력,이동방향,크기
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			shark.add(new Shark(i,r, c, s, d, z));
			sea[r][c].add(i);
		}
		boolean[] check = new boolean[m+1];
		int answer = 0;
		for(int j=1;j<=C;j++){
			//출력
//			System.out.println();
//			for(int x=1;x<=m;x++){
//				if(!check[x]){
//					System.out.println(shark.get(x).toString());
//				}
//			}
			//낚시
			for(int i=1;i<=R;i++){
				int size = sea[i][j].size();
				if(sea[i][j].size()>0){
					int index = sea[i][j].get(0);
					sea[i][j].remove(0);
					for(int x=1;x<=m;x++){
						if(shark.get(x).no==index){
							answer += shark.get(x).z;
							check[index] = true;
							break;
						}
					}
					break;
				}
			}
			
			//상어이동
			init(sea);
			for(int x=1;x<=m;x++){
				if(!check[x]){
					Shark temp = shark.get(x);
					int tr = temp.r;
					int tc = temp.c;
					int td = temp.d;
					int ts = temp.s;
					if(td<=2){
						ts %= (R-1)*2;
						for(int ss=0;ss<ts;ss++){
							if(td==1){
								tr--;
								if(tr<1){
									tr+=2;
									td=2;
								}
							}else{
								tr++;
								if(tr>R){
									tr-=2;
									td=1;
								}
							}
						}
					}else {
						ts %= (C-1)*2;
						for(int ss=0;ss<ts;ss++){
							if(td==3){
								tc++;
								if(tc>C){
									tc-=2;
									td=4;
								}
							}else{
								tc--;
								if(tc<1){
									tc+=2;
									td=3;
								}
							}
						}
					}
					temp.r = tr;
					temp.c = tc;
					temp.d = td;
					sea[tr][tc].add(temp.no);
				}
			}
			//잡아먹기
			for(int x=1;x<=R;x++){
				for(int y=1;y<=C;y++){
					if(sea[x][y].size()>1){
						
						Collections.sort(sea[x][y], new Comparator<Integer>() {

							@Override
							public int compare(Integer o1, Integer o2) {
								// TODO Auto-generated method stub
								return shark.get(o2).z-shark.get(o1).z;
							}
						});
						int size = sea[x][y].size();
						for(int z=size-1;z>0;z--){
							check[sea[x][y].get(z)] = true;
							sea[x][y].remove(z);
						}
					}
				}
			}
		}
		System.out.println(answer);

	}
	
	static void init(ArrayList<Integer>[][] sea){
		for(int i=0;i<=R;i++){
			for(int j=0;j<=C;j++){
				sea[i][j] = new ArrayList<>();
			}
		}
	}
	
	static int turn(int d){
		int td = 0;
		switch(d){
		case 1:
			td = 2;
			break;
		case 2:
			td = 1;
			break;
		case 3:
			td = 4;
			break;
		case 4:
			td = 3;
			break;
		}
		return td;
	}

	static class Shark{
		int no;
		int r;
		int c;
		int s;
		int d;
		int z;
		
		public Shark(int no, int r, int c, int s, int d, int z) {
			super();
			this.no = no;
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}

		@Override
		public String toString() {
			return "Shark [no=" + no + ", r=" + r + ", c=" + c + ", s=" + s
					+ ", d=" + d + ", z=" + z + "]";
		}
		
	}
}
