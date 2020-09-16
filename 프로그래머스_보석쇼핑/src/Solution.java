import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
/*
 * 프로그래머스 보석 쇼핑
 * 2020 카카오 인턴십
 * 시작일 : 2020-09-16
 * 완료일 : ``
 * 투 포인터
 */
public class Solution {

	public static void main(String[] args) {
		String[] g1 = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
		System.out.println(Arrays.toString(solution(g1)));
		String[] g2 = {"AA", "AB", "AC", "AA", "AC"};
		System.out.println(Arrays.toString(solution(g2)));		
		String[] g3 = {"XYZ", "XYZ", "XYZ"};
		System.out.println(Arrays.toString(solution(g3)));
		String[] g4 = {"ZZZ", "YYY", "NNNN", "YYY", "BBB"};
		System.out.println(Arrays.toString(solution(g4)));
	}
	
	public static int[] solution(String[] gems) {
		int[] answer = new int[2];
        int n = gems.length;
        HashSet<String> set = new HashSet<>();
        for(int i=0;i<n;i++) {
        	set.add(gems[i]);        	
        }
        int kinds = set.size();
        
        HashMap<String, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int sum = 0;       
        int length = Integer.MAX_VALUE;
        while(left<=right) {
        	if(sum<kinds) {
        		if(right>=n) {
        			break;
        		}
        		String temp = gems[right++];
        		if(map.containsKey(temp)) {
        			if(map.get(temp)==0) {
        				map.put(temp, 1);
        				sum++;
        			}else {
        				int v = map.get(temp);
        				map.put(temp, v+1);
        			}
        		}else {
        			map.put(temp,1);
        			sum++;
        		}
        	}else if(sum>=kinds) {
        		if(length>right-left) {
        			length = right-left;
        			answer[0] = left+1;
        			answer[1] = right;
        		}
        		String temp = gems[left++];
        		int v = map.get(temp);
        		if(v==1) {
        			sum--;
        		}
        		map.put(temp, v-1);
        	}
        }

        return answer;
    }

}
