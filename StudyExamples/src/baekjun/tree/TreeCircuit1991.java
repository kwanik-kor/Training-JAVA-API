package baekjun.tree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class TreeCircuit1991 {
	static int N;
	static Node tree[];
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder("");
	
	static void preorder(int idx) {
		sb.append(tree[idx].c);
		if(tree[idx].l != null) preorder(tree[idx].l.c - 'A');
		if(tree[idx].r != null) preorder(tree[idx].r.c - 'A');
	}
	
	static void inorder(int idx) {
		if(tree[idx].l != null) inorder(tree[idx].l.c - 'A');
		sb.append(tree[idx].c);
		if(tree[idx].r != null) inorder(tree[idx].r.c - 'A');
	}
	
	static void postorder(int idx) {
		if(tree[idx].l != null) postorder(tree[idx].l.c - 'A');
		if(tree[idx].r != null) postorder(tree[idx].r.c - 'A');
		sb.append(tree[idx].c);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		tree = new Node[N];
		for(int i = 0; i<N; i++)
			tree[i] = new Node((char)(i + 'A'));
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			char parent = st.nextToken().charAt(0);
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);
			if(left != '.') tree[parent - 'A'].l = tree[left - 'A'];
			if(right != '.') tree[parent - 'A'].r = tree[right - 'A'];
		}
		preorder(0);
		sb.append("\n");
		inorder(0);
		sb.append("\n");
		postorder(0);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
	static class Node{
		Node l, r;
		char c;
		public Node(char c) {
			this.c = c;
		}
	}
}
