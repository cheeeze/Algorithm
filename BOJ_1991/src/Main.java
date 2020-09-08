import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * BOJ #1991 트리 순회
 * 시작일 : 2020-09-08
 * 완료일 : ``
 * 트리
 */
public class Main {

	static StringBuilder sb;
	static Node[] tree;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		tree = new Node[n];
		for(int i=0;i<n;i++) {
			tree[i] = new Node((char) ('A'+i));
		}
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char v = st.nextToken().charAt(0);
			int index = v-'A';
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);
			if(left!='.') {
				int leftindex = left-'A';
				tree[index].left = tree[leftindex];
			}
			if(right!='.') {
				int rightindex = right-'A';
				tree[index].right = tree[rightindex];
			}			
		}
		
		sb = new StringBuilder();
		preorder(tree[0]);
		sb.append('\n');
		inorder(tree[0]);
		sb.append('\n');
		postorder(tree[0]);
		System.out.println(sb.toString());

	}
	
	static void preorder(Node node) {
		sb.append(node.v);
		if(node.left!=null) {
			preorder(node.left);
		}
		if(node.right!=null) {
			preorder(node.right);
		}
	}
	
	static void inorder(Node node) {	
		if(node.left!=null) {
			inorder(node.left);
		}
		sb.append(node.v);		
		if(node.right!=null) {
			inorder(node.right);
		}
	}
	
	static void postorder(Node node) {
		if(node.left!=null) {
			postorder(node.left);
		}
		if(node.right!=null) {
			postorder(node.right);
		}
		sb.append(node.v);
	}
	
	static class Node {
		Node left;
		Node right;
		char v;
		
		public Node(char v) {
			this.v = v;
		}
		
	}

}
