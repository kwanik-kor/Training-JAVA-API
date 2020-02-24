package baekjun.tree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class DiameterOfTree1167 {
	static int V, ans = 0, idx = 0;
	static int dist[];
	static boolean visited[];
	static LinkedList<Node> list[];
	static StringTokenizer st;
	
	static void dijkstra(int start) {
		initArr();
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			if(visited[now.e]) continue;
			visited[now.e] = true;
			for(Node n : list[now.e]) {
				if(!visited[n.e] && dist[n.e] < dist[now.e] + n.v) {
					dist[n.e] = dist[now.e] + n.v;
					pq.add(new Node(n.e, dist[n.e]));
				}
			}
		}
		for(int i = 1; i<=V; i++) {
			if(ans < dist[i]) {
				idx = i;
				ans = dist[i];
			}
		}
	}
	
	static void initArr() {
		for(int i = 1; i<=V; i++) {
			visited[i] = false;
			dist[i] = 0;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		V = Integer.parseInt(br.readLine());
		list = new LinkedList[V+1];
		dist = new int[V+1];
		visited = new boolean[V+1];
		for(int i = 1; i<=V; i++) {
			list[i] = new LinkedList<Node>();
		}
		for(int k = 1; k<=V; k++) {
			st = new StringTokenizer(br.readLine());
			int node = Integer.parseInt(st.nextToken());
			int e;
			while((e = Integer.parseInt(st.nextToken())) != -1) {
				int v = Integer.parseInt(st.nextToken());
				list[node].add(new Node(e, v));
			}
		}
		dijkstra(1);
		dijkstra(idx);
		bw.write(ans + "");
		bw.flush();
		bw.close();
		br.close();
	}
	
	static class Node implements Comparable<Node>{
		int e;
		int v;
		public Node(int e, int v) {
			this.e = e;
			this.v = v;
		}
		@Override
		public int compareTo(Node n) {
			return n.v - this.v;
		}
	}
}
