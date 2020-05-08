import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.StringTokenizer;

/*
 * 프로그래머스 튜플
 * 2019 카카오 개발자 겨울 인턴십
 * 시작일 : 2020-05-08
 * 완료일 : ``
 * 문자열
 */
public class Solution {
	
	public static void main(String[] args) {
		String s1 = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
		String s2 = "{{1,2,3},{2,1},{1,2,4,3},{2}}";
		String s3 = "{{20,111},{111}}";
		String s4 = "{{123}}";
		String s5 = "{{4,2,3},{3},{2,3,4,1},{2,3}}";
		System.out.println(Arrays.toString(solution(s5)));
	}
	
	public static int[] solution(String s) {
        int len = s.length();
        s = s.substring(1,len-1);
        len = s.length();
        ArrayList<String> list = new ArrayList<>();
        for(int i=0;i<len;i++) {
        	if(s.charAt(i)=='{') {
        		for(int j=i+1;j<len;j++) {
        			if(s.charAt(j)=='}') {
        				list.add(s.substring(i+1,j));
        				break;
        			}
        		}
        	}
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = list.size();
        for(int i=0;i<n;i++) {
        	StringTokenizer st = new StringTokenizer(list.get(i),",");
        	while(st.hasMoreTokens()) {
        		int x = Integer.parseInt(st.nextToken());
        		if(map.containsKey(x)) {
        			int v = map.get(x);
        			map.put(x, v+1);
        		}else {
        			map.put(x,1);
        		}
        	}
        }
        ArrayList<Integer> KeySetList = new ArrayList<>(map.keySet());
        Collections.sort(KeySetList,new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return map.get(o2).compareTo(map.get(o1));
			}
		});
        
        int[] answer = new int[KeySetList.size()];
        for(int i=0;i<KeySetList.size();i++) {
        	answer[i] = KeySetList.get(i);
        }
        return answer;
    }
}
