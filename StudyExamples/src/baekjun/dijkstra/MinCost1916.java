package baekjun.dijkstra;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class MinCost1916 {
	static int N, M;
	static int dist[];
	static boolean visit[];
	static final int INF = 987654321;
	static int map[][];
	static StringTokenizer st;
	
	static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		dist[start] = 0;
		map[start][start] = 0;
		pq.add(new Node(start, 0));
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			if(visit[now.idx]) continue;
			visit[now.idx] = true;
			for(int i = 1; i<=N; i++) {
				if(dist[i] > dist[now.idx] + map[now.idx][i]) {
					dist[i] = dist[now.idx] + map[now.idx][i];
					pq.add(new Node(i, dist[i]));
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		dist = new int[N+1];
		visit = new boolean[N+1];
		map = new int[N+1][N+1];
		for(int i = 1; i<=N; i++) {
			dist[i] = INF;
			for(int j = 1; j<=N; j++)
				map[i][j] = INF;
		}
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			if(map[from][to] > cost)
				map[from][to] = cost;
		}
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		dijkstra(start);
		bw.write(dist[end] + "");
		bw.flush();
		bw.close();
		br.close();
	}
	
	static class Node implements Comparable<Node>{
		int idx;
		int val;
		public Node(int idx, int val) {
			this.idx = idx;
			this.val = val;
		}
		@Override
		public int compareTo(Node n) {
			return this.val - n.val;
		}
	}
}
