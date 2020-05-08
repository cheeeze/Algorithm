import java.util.ArrayList;
import java.util.LinkedList;

/*
 * 프로그래머스 불량 사용자
 * 2019 카카오 개발자 겨울 인턴십
 * 시작일 : 2020-05-08
 * 완료일 : 2020-05-09
 * 완전탐색, DFS
 */
public class Solution {
	
	static int answer = 0;
	static ArrayList<ArrayList> banList;
	
	public static void main(String[] args) {
		String[] user1 = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
		String[] ban1 = {"fr*d*", "abc1**"};
		String[] user2 = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
		String[] ban2 = {"*rodo", "*rodo", "******"};
		String[] user3 = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
		String[] ban3 = {"fr*d*", "*rodo", "******", "******"};
		System.out.println(solution(user3,ban3));

	}
	
	public static int solution(String[] user_id, String[] banned_id) {
		int n = user_id.length;
		int m = banned_id.length;
		LinkedList<Integer>[] list = new LinkedList[n];
		banList = new ArrayList<>();
		boolean[] checked = new boolean[n];
		boolean flag = true;
		for(int i=0;i<n;i++) {
			list[i] = new LinkedList<>();			
			for(int j=0;j<m;j++) {
				if(user_id[i].length()!=banned_id[j].length()) {
					flag = false;
				}
				if(flag) {
					for(int d=0;d<banned_id[j].length();d++) {
						if(banned_id[j].charAt(d)!='*') {
							if(banned_id[j].charAt(d)!=user_id[i].charAt(d)) {
								flag = false;
								break;
							}						
						}
					}
				}
				if(flag) {
					list[i].add(j);
				}
				flag = true;
			}
		}
        answer = 0;
        recur(n,m,0,list,checked,user_id);
        
        return answer;
    }
	
	static void recur(int n, int m, int k, LinkedList<Integer>[] list, boolean[] visited,String[] user_id) {
		if(k==m) {
			ArrayList<String> temp = new ArrayList<>();
			for(int i=0;i<n;i++) {
				if(visited[i]) {
					temp.add(user_id[i]);
				}
			}
			
			int cnt = 0;
			for(int i=0;i<banList.size();i++) {
				ArrayList<String> t = banList.get(i);
				boolean flag = false;
				for(int j=0;j<temp.size();j++) {
					if(!temp.contains(t.get(j))) {
						flag = true;
						break;
					}
				}
				if(flag) {
					cnt++;
				}
			}
			
			if(cnt==banList.size()) {
				banList.add(temp);
				answer++;
			}
			return ;
		}
		
		for(int i=0;i<n;i++) {
			if(!visited[i] && list[i].contains(k)) {
				visited[i] = true;
				recur(n,m,k+1,list,visited,user_id);
				visited[i] = false;
			}
		}

	}

}
