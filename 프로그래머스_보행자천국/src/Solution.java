/*
 * 프로그래머스 보행자 천국
 * 2017 카카오코드 예선
 * 시작일 : 2020-08-10
 * 완료일 : ``
 * DP
 */
public class Solution {

	static int MOD = 20170805;
	public static void main(String[] args) {
		int[][] map1 = {{0,0,0},{0,0,0},{0,0,0}};
		int[][] map2= {{0,2,0,0,0,2},{0,0,2,0,1,0},{1,0,0,2,2,0}};
		System.out.println(solution(3,3,map1));
		System.out.println(solution(3,6,map2));
	}

	static int solution(int m, int n, int[][] cityMap) {
		int answer = 0;		
		int[][][] map = new int[m][n][3];
		map[0][0][0] = 1;
		map[0][0][1] = 1;
		map[0][0][2] = 1;
		//0은 오->왼 1은 상->하
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(i==0 && j==0) {
					continue;
				}else if(i==0) {
					switch(cityMap[i][j-1]) {
					case 0:
						map[i][j][0] = map[i][j-1][2];
						break;					
					case 1:
						map[i][j][0] = 0;
						break;
					case 2:
						map[i][j][0] = map[i][j-1][0];
						break;
					}
				}else if(j==0) {
					switch(cityMap[i-1][j]) {
					case 0:
						map[i][j][1] = map[i-1][j][2];
						break;					
					case 1:
						map[i][j][1] = 0;
						break;
					case 2:
						map[i][j][1] = map[i-1][j][1];
						break;
					}
				}else {
					switch(cityMap[i][j-1]) {
					case 0:
						map[i][j][0] = map[i][j-1][2];
						break;
					case 1:
						break;
					case 2:
						map[i][j][0] = map[i][j-1][0];
						break;
					}
					switch(cityMap[i-1][j]) {
					case 0:
						map[i][j][1] = map[i-1][j][2];
						break;
					case 1:
						break;
					case 2:
						map[i][j][1] = map[i-1][j][1];
						break;
					}					
				}
				map[i][j][0] %= MOD;
				map[i][j][1] %= MOD;
				map[i][j][2] = (map[i][j][0]+map[i][j][1])%MOD;
			}
		}
		answer = map[m-1][n-1][2];
		return answer;
	}
	
}
