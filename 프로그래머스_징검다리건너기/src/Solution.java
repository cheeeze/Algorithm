/*
 * 프로그래머스 징검다리 건너기
 * 2019 카카오 개발자 겨울 인턴십
 * 시작일 : 2020-08-03
 * 완료일 : ``
 * 이분탐색
 */
public class Solution {

	public static void main(String[] args) {
		int[] s1 = {2,4,5,3,2,1,4,2,5,1};
		
		System.out.println(solution(s1,3));
	}
	
	public static int solution(int[] stones, int k) {
        int max = 200000000;
        int min = 0;
        
        int len = stones.length;
        while(max>min) {
        	int mid = (max+min)/2;
        	int cnt = 0;
        	boolean check = true;
        	for(int i=0;i<len;i++) {
        		if(stones[i]-mid<=0) {
        			cnt++;
        		}else {
        			if(cnt>=k) {
        				check = false;
        				break;
        			}
        			cnt = 0;
        		}
        	}
        	if(cnt>=k) {
        		check = false;
        	}
        	if(check) {
        		min = mid+1;
        	}else {
        		max = mid;
        	}
        }
        
        return max;
    }

}
