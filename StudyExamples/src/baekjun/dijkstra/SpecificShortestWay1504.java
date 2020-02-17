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
	static int N, E, dist[][], INF = 100000000;
	static LinkedList<Node> adj[];
	static boolean visited[];
	
	static void dijkstra(int start, int idx) {
		for(int i = 0; i<visited.length; i++) 
			visited[i] = false;
		PriorityQueue<Node> pq = new PriorityQueue<>();
		dist[idx][start] = 0;
		pq.add(new Node(start, 0));
		while(!pq.isEmpty()) {
			int now = pq.poll().index;
			if(visited[now]) continue;
			visited[now] = true;
			for(Node n : adj[now]) {
				if(dist[idx][n.index] > dist[idx][now] + n.value) {
					dist[idx][n.index] = dist[idx][now] + n.value;
					pq.add(new Node(n.index, dist[idx][n.index]));
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
		dist = new int[3][N+1];
		for(int i = 1; i<=N; i++) {
			adj[i] = new LinkedList<Node>();
			for(int j = 0; j<3; j++)
				dist[j][i] = INF;
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
		int p1 = Integer.parseInt(st.nextToken());
		int p2 = Integer.parseInt(st.nextToken());
		dijkstra(1, 0);
		dijkstra(p1, 1);
		dijkstra(p2, 2);
		int result = Math.min(dist[0][p1] + dist[1][p2] + dist[2][N], dist[0][p2] + dist[2][p1] + dist[1][N]);
		bw.write(((result >= INF)? -1 : result)+ "");
		bw.flush();
		bw.close();
		br.close();
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
