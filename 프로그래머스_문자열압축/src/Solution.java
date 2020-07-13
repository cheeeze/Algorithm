/*
 * 프로그래머스 문자열 압축
 * 2020 KAKAO BLIND RECRUITMENT
 * 시작일 : 2020-07-13
 * 완료일 : 2020-07-14
 * 완전탐색, 구현
 */
public class Solution {

	public static void main(String[] args) {
		System.out.println(solution("aabbaccc"));//7
		System.out.println(solution("ababcdcdababcdcd"));//9
		System.out.println(solution("abcabcdede"));//8
		System.out.println(solution("abcabcabcabcdededededede"));//14
		System.out.println(solution("xababcdcdababcdcd"));//17
		
		System.out.println("======");
		System.out.println(solution("ababababababababababab"));
		System.out.println(solution("abababababababababababcd"));
	}
	
	public static int solution(String s) {
        int len = s.length();
        int min = len;
        for(int i=1;i<=len;i++) {
        	int length = i;
        	int cnt = 1;
        	boolean dup = false;
        	String prev = s.substring(0,i);
        	for(int j=i;j<len;j+=i) {
        		String sub = "";
        		if(j+i<len) {
        			sub = s.substring(j,j+i);     			
        			if(prev.equals(sub)) {
        				cnt++;
        				if(dup) {
        					continue;
        				}
        				dup = true;
        				length += 1;
        			}else {       				
        				prev = sub;
        				dup = false;
        				length += i;
        				length += (int)Math.log10(cnt);
        				cnt = 1;
        			}
        		}else {
        			sub = s.substring(j);
        			if(prev.equals(sub)) {
        				cnt++;
        				if(dup) {
        					continue;
        				}
        				dup = true;
        				length += 1;
        			}else {
        				prev = sub;
        				dup = false;
        				length += sub.length();
        				length += (int)Math.log10(cnt);
        				cnt = 1;
        			}
        		}
        	}
        	
        	if(dup) {
        		length+=(int)Math.log10(cnt);
        	}
        	if(length<min) {
        		min = length;
        	}
        	
        }
        
        return min;
    }

}
