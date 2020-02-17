package baekjun.dijkstra;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Wormhole1865 {
	static int N, M, W, dist[];
	static int INF = 1000000000;
	static Node edge[];
	
	static boolean bellmanFord() {
		for(int i = 0; i<N-1; i++) {
			for(int j = 1; j<edge.length; j++) {
				Node n = edge[j];
				if(dist[n.s] != INF && dist[n.e] > dist[n.s] + n.v) {
					dist[n.e] = dist[n.s] + n.v;
				}
			}
		}
		
		for(int i = 1; i<edge.length; i++) {
			Node n = edge[i];
			if(dist[n.s] != INF && dist[n.e] > dist[n.s] + n.v) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCase = Integer.parseInt(br.readLine());
		for(int t = 0; t<testCase; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			dist = new int[N+1];
			edge = new Node[2*M + W + 1];
			for(int i = 1; i<=N; i++) dist[i] = INF;
			
			for(int i = 1; i<=M+W; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				if(i<=M) {
					edge[2*i - 1] = new Node(a, b, v);
					edge[2*i] = new Node(b, a, v);
				}else {
					edge[M + i] = new Node(a, b, v*(-1));
				}
			}
			dist[1] = 0;
			if(bellmanFord())
				bw.write("NO\n");
			else
				bw.write("YES\n");
		}
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
			this.v = v;
			this.e = e;
		}
	}
}
