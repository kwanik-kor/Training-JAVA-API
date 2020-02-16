package baekjun.dijkstra;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SpecificShortestWay1504 {
	static int N, E, dist[], INF = 1000000000;
	static LinkedList<Node> adj[];
	static boolean visited[];
	
	//this should be changed into multiple array to resolve this problem
	static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		dist[start] = 0;
		pq.add(new Node(start, 0));
		while(!pq.isEmpty()) {
			int now = pq.poll().index;
			if(visited[now]) continue;
			visited[now] = true;
			for(Node n : adj[now]) {
				if(dist[n.index] > dist[now] + n.value) {
					dist[n.index] = dist[now] + n.value;
					pq.add(new Node(n.index, dist[n.index]));
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		adj = new LinkedList[N+1];
		visited = new boolean[N+1];
		dist = new int[N+1];
		for(int i = 1; i<=N; i++) {
			adj[i] = new LinkedList<Node>();
			dist[i] = INF;
		}
		for(int e = 0; e<E; e++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			adj[a].add(new Node(b, v));
			adj[b].add(new Node(a, v));
		}
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		dijkstra(start);
		for(int i = 1; i<=N; i++) {
			System.out.println(dist[i]);
		}
	}
	
	static class Node implements Comparable<Node>{
		int index;
		int value;
		public Node(int i, int v) {
			this.index = i;
			this.value = v;
		}
		@Override
		public int compareTo(Node n) {
			return this.value - n.value;
		}
		
	}
}
