package baekjun.tree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BinarySearchTree5639 {
	static StringBuilder sb = new StringBuilder("");
	
	static void postOrder(Node n) {
		if(n.l != null) postOrder(n.l);
		if(n.r != null) postOrder(n.r);
		sb.append(n.num + "\n");
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Node node = new Node(Integer.parseInt(br.readLine()));
		String s = "";
		while((s = br.readLine()) != null && s.length() != 0) {
			node = node.addTree(node, Integer.parseInt(s));
		}
		postOrder(node);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
	static class Node{
		Node l, r;
		int num;
		public Node(int num) {
			this.num = num;
		}
		
		public Node addTree(Node n, int num) {
			Node temp = null;
			if(n == null) return new Node(num);
			if(n.num > num) {
				temp = addTree(n.l, num);
				n.l = temp;
			}else{
				temp = addTree(n.r, num);
				n.r = temp;
			}
			return n;
		}
	}
}
