package baekjun.tree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class DiameterOfTree1967 {
	static int N, ans = 0, idx = 0;
	static int dist[];
	static boolean visited[];
	static LinkedList<Node> list[];
	static StringTokenizer st;
	
	static void dijkstra(int start) {
		for(int i = 1; i<=N; i++) {
			dist[i] = 0;
			visited[i] = false;
		}
		
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
			for(int i = 1; i<=N; i++) {
				if(dist[i] > ans) {
					idx = i;
					ans = dist[i];
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		dist = new int[N+1];
		visited = new boolean[N+1];
		list = new LinkedList[N+1];
		for(int i = 1; i<=N; i++)
			list[i] = new LinkedList<>();
		for(int i = 1; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			list[a].add(new Node(b, v));
			list[b].add(new Node(a, v));
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
