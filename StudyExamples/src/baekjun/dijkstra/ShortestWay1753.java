package baekjun.dijkstra;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class ShortestWay1753 {
	static int V, E, start, dist[];
	static int INF = 100000000;
	static boolean visited[];
	static LinkedList<Node> adj[];
	
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
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(br.readLine());
		adj = new LinkedList[V+1];
		visited = new boolean[V+1];
		dist = new int[V+1];
		for(int i = 1; i<=V; i++){
			adj[i] = new LinkedList<Node>();
			dist[i] = INF;
		}
		
		for(int e = 0; e<E; e++) {
			st = new StringTokenizer(br.readLine());
			adj[Integer.parseInt(st.nextToken())].add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		dijkstra(start);
		for(int i = 1; i<=V; i++) {
			bw.write(((dist[i] == INF)? "INF": dist[i]) + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	static class Node implements Comparable<Node> {
		int index;
		int value;
		public Node(int index, int value) {
			this.index = index;
			this.value = value;
		}
		@Override
		public int compareTo(Node n) {
			return this.value - n.value;
		}
	}
}
