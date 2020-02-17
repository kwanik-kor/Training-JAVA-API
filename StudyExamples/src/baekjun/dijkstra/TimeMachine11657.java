package baekjun.dijkstra;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class TimeMachine11657 {
	static int N, M, dist[];
	static int INF = 1000000000;
	static Node adj[];
	
	static boolean bellmanFord() {
		for(int i = 0; i<N - 1; i++) {
			for(int j = 1; j<=M; j++) {
				if(dist[adj[j].s] != INF && dist[adj[j].e] > dist[adj[j].s] + adj[j].v)
					dist[adj[j].e] = dist[adj[j].s] + adj[j].v;
			}
		}
		
		for(int i = 1; i<=M; i++) {
			if(dist[adj[i].s] != INF && dist[adj[i].e] > dist[adj[i].s] + adj[i].v)
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		dist = new int[N+1];
		adj = new Node[M+1];
		for(int i = 1; i <= N; i++)
			dist[i] = INF;
		for(int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			adj[i] = new Node(a, b, v);
		}
		dist[1] = 0;
		if(bellmanFord()) {
			for(int i = 2; i<=N; i++)
				bw.write(((dist[i] == INF)? -1 : dist[i]) + "\n");
		}else
			bw.write("-1");
		bw.flush();
		bw.close();
		br.close();
	}
	
	static class Node{
		int s;
		int e;
		int v;
		public Node(int s, int e, int v) {
			this.s = s;
			this.e = e;
			this.v = v;
		}
	}
}
