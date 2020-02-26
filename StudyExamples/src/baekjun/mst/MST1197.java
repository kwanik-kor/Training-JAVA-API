package baekjun.mst;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class MST1197 {
	static int V, E, parent[];
	static ArrayList<Node> arr = new ArrayList<>();
	static StringTokenizer st;
	
	static boolean isSameParent(int a, int b) {
		a = findParent(a);
		b = findParent(b);
		if(a == b) return true;
		return false;
	}
	
	static int findParent(int node) {
		if(parent[node] == node) return node;
		return parent[node] = findParent(parent[node]);
	}
	
	static void union(int a, int b) {
		a = findParent(a);
		b = findParent(b);
		if(a != b)
			parent[b] = a;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		parent = new int[V+1];
		for(int i = 1; i<=V; i++)
			parent[i] = i;
		for(int e = 0; e<E; e++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			arr.add(new Node(a, b, v));
		}
		Collections.sort(arr);
		int sum = 0;
		for(Node n : arr) {
			if(!isSameParent(n.start, n.end)) {
				sum += n.val;
				union(n.start, n.end);
			}
		}
		
		bw.write(sum + "");
		bw.flush();
		bw.close();
		br.close();
	}
	
	static class Node implements Comparable<Node>{
		int start;
		int end;
		int val;
		public Node(int start, int end, int val) {
			this.start = start;
			this.end = end;
			this.val = val;
		}
		@Override
		public int compareTo(Node n) {
			return this.val - n.val;
		}
		
	}
}
