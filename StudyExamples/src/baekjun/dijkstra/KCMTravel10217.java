package baekjun.dijkstra;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class KCMTravel10217 {
	static StringTokenizer st;
	static final int INF = 1000000000;
	static int N, M, K, dist[][];
	static boolean visit[];
	static LinkedList<Plane> adj[];
	
	static void dijkstra(int start) {
		PriorityQueue<Plane> pq = new PriorityQueue<>();
		dist[start][0] = 0;
		pq.add(new Plane(start, 0, 0));
		while(!pq.isEmpty()) {
			Plane now = pq.poll();
			if(visit[now.arrival]) continue;
			if(dist[now.arrival][now.cost] < now.time) continue;
			dist[now.arrival][now.cost] = now.time;
			
			for(Plane p : adj[now.arrival]) {
				if(now.cost + p.cost > M) continue;
				if(dist[p.arrival][now.cost + p.cost] > now.time + p.time) {
					for(int j = now.cost + p.cost; j<=M; j++) {
						if(dist[p.arrival][j] > now.time + p.time) dist[p.arrival][j] = now.time + p.time;
					}
					pq.add(new Plane(p.arrival, now.cost + p.cost, now.time + p.time));
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCase = Integer.parseInt(br.readLine());
		for(int t = 0; t<testCase; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			dist = new int[N+1][M+1];
			visit = new boolean[N+1];
			adj = new LinkedList[N+1];
			for(int i = 1; i<=N; i++) {
				Arrays.fill(dist[i], INF);
				adj[i] = new LinkedList<Plane>();
			}
			for(int k = 0; k<K; k++) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				adj[u].add(new Plane(v, c, d));
			}
			dijkstra(1);
			int result = Integer.MAX_VALUE;
			for(int i = 1; i<=M; i++) {
				result = Math.min(result, dist[N][i]);
			}
			bw.write(((result >= INF)? "Poor KCM":result) + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	static class Plane implements Comparable<Plane>{
		int arrival;
		int cost;
		int time;
		public Plane(int arrival, int cost, int time) {
			this.arrival = arrival;
			this.cost = cost;
			this.time = time;
		}
		@Override
		public int compareTo(Plane p) {
			return this.time - p.time;
		}
	}
}
