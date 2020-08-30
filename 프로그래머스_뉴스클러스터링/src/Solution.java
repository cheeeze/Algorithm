import java.util.ArrayList;
import java.util.HashMap;

/*
 * 프로그래머스 [1차] 뉴스 클러스터링
 * 2018 KAKAO BLIND RECRUITMENT
 * 시작일 : 2020-08-30
 * 완료일 : ``
 * 구현
 */
public class Solution {

	public static void main(String[] args) {
		System.out.println(solution("FRANCE", "french"));
		System.out.println(solution("handshake", "shake hands"));
		System.out.println(solution("aa1+aa2", "AAAA12"));
		System.out.println(solution("E=M*C^2", "e=m*c^2"));
	}
	
	public static int solution(String str1, String str2) {
        int answer = 0;
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        int len1 = str1.length();
        int len2 = str2.length();
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        boolean check = false; //prev char : A-Z
        
    	if(str1.charAt(0)>='A' && str1.charAt(0)<='Z') {
    		check = true;
        }
        
        for(int i=1;i<len1;i++) { 
    		if(str1.charAt(i)>='A' && str1.charAt(i)<='Z') {
    			if(check) {
    				list1.add(str1.substring(i-1,i+1));
    			}
    			check = true;
    		}else {
    			check = false;
    		}
        }
        
        check = false;
        
        if(str2.charAt(0)>='A' && str2.charAt(0)<='Z') {
    		check = true;
        }
        
        for(int i=1;i<len2;i++) { 
    		if(str2.charAt(i)>='A' && str2.charAt(i)<='Z') {
    			if(check) {
    				list2.add(str2.substring(i-1,i+1));
    			}
    			check = true;
    		}else {
    			check = false;
    		}
        }
        
        int size1 = list1.size();
        int size2 = list2.size();

        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        
        for(int i=0;i<size1;i++) {
        	String t = list1.get(i);
        	if(map1.containsKey(t)) {
        		int v = map1.get(t);
        		map1.put(t, v+1);
        	}else {
        		map1.put(t, 1);
        	}
        }
        for(int i=0;i<size2;i++) {
        	String t = list2.get(i);
        	if(map2.containsKey(t)) {
        		int v = map2.get(t);
        		map2.put(t, v+1);
        	}else {
        		map2.put(t, 1);
        	}
        }
        
        int union = 0;//합집합
        int inter = 0;//교집합
        
        for(int i=0;i<size1;i++) {
        	String t = list1.get(i);
        	if(map1.containsKey(t)) {
        		int v1 = map1.get(t);
        		if(map2.containsKey(t)) {    			
        			int v2 = map2.get(t);
        			union += Integer.max(v1, v2);
        			inter += Integer.min(v1, v2);
        			map2.remove(t);
        		}else {
        			union += v1;
        		}
        		map1.remove(t);
        	}
        }
        for(int i=0;i<size2;i++) {
        	String t = list2.get(i);
        	if(map2.containsKey(t)) {
        		union += map2.get(t);
        	}
        	map2.remove(t);
        }
        
        //union = size1+size2-inter; 합집합크기 공식
        
        double similar = 1;
        if(union!=0) {
        	similar = inter/(double)union;
        }
        answer = (int) (similar*65536);
        return answer;
    }

}
