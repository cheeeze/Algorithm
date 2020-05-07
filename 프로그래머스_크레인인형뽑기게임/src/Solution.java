import java.util.LinkedList;

/*
 * 프로그래머스 크레인 인형뽑기 게임
 * 2019 카카오 개발자 겨울 인턴십
 * 시작일 : 2020-05-07
 * 완료일 : ``
 * 구현
 */
public class Solution {

	public static void main(String[] args) {
		int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
		int[] moves = {1,5,3,5,1,2,1,4};
		System.out.println(solution(board,moves));

	}
	
	public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        int n = board.length;
        int k = moves.length;
        LinkedList<Integer> stack = new LinkedList<>();

        for(int i=0;i<k;i++) {
        	int c = moves[i]-1;
    		for(int r=0;r<n;r++) {
    			if(board[r][c]==0) {
    				continue;
    			}
    			if(stack.size()>0) {
    				if(stack.getLast()==board[r][c]) {
    					stack.removeLast();
    					answer+=2;
    					board[r][c] = 0;
            			break;
    				}
    			}
    			stack.add(board[r][c]);
    			board[r][c] = 0;
    			break;
    		}

        }
        return answer;
    }

}
