import java.util.Collections;
import java.util.LinkedList;

/*
 * 프로그래머스 길 찾기 게임
 * 2019 KAKAO BLIND RECRUITMENT
 * 시작일 : 2020-09-08
 * 완료일 : 2020-09-10
 * 트리, 재귀
 */
public class Solution {

	public static void main(String[] args) {
		int[][] info = {{5, 3}, {11, 5}, {13, 3}, {3, 5}, {6, 1}, {1, 3}, {8, 6}, {7, 2}, {2, 2}};
		//System.out.println(solution(info));//[[7, 4, 6, 9, 1, 8, 5, 2, 3], [9, 6, 5, 8, 1, 4, 3, 2, 7]]
		int[][] answer = solution(info);
		for(int i=0;i<answer.length;i++) {
			for(int j=0;j<answer[i].length;j++) {
				System.out.print(answer[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public static int[][] solution(int[][] nodeinfo) {      
        int n = nodeinfo.length;
        int[][] answer = new int[2][n];
        LinkedList<Node> node = new LinkedList<>();
        for(int i=0;i<n;i++) {
        	node.add(new Node(nodeinfo[i][0],nodeinfo[i][1],i+1));
        }
        Collections.sort(node);
        Node root = node.get(0);
        for(int i=1;i<n;i++) {
        	maketree(root,node.get(i));
        }
        k = 0;
        preorder(root, answer);
        k = 0;
        postorder(root, answer);
        
        return answer;
    }
	
	static int k = 0;
	
	static void preorder(Node node, int[][] order) {
		order[0][k++] = node.v;
		if(node.left != null) {
			preorder(node.left,order);
		}
		if(node.right != null) {
			preorder(node.right,order);
		}
	}
	
	static void postorder(Node node, int[][] order) {
		if(node.left != null) {
			postorder(node.left,order);
		}
		if(node.right != null) {
			postorder(node.right,order);
		}
		order[1][k++] = node.v;
	}
	
	static void maketree(Node prev, Node now) {
		if(prev.x>now.x) {
			if(prev.left!=null) {
				maketree(prev.left,now);
			}else {
				prev.left = now;
			}
		}else {
			if(prev.right!=null) {
				maketree(prev.right,now);
			}else {
				prev.right = now;
			}
		}
	}
	
	static class Node implements Comparable<Node>{
		int x;
		int y;
		Node left;
		Node right;
		int v;
		
		public Node(int x, int y, int v) {
			super();
			this.x = x;
			this.y = y;
			this.v = v;
		}

		@Override
		public int compareTo(Node o) {
			if(o.y==this.y) {
				return this.x-o.x;
			}
			return o.y-this.y;
		}
	}

}
