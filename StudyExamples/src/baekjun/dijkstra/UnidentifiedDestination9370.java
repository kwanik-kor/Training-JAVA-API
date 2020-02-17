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

public class UnidentifiedDestination9370 {
	static int INF = 10000000;
	static int N, M, T, S, G, H, dist[], candidate[];
	static boolean visited[];
	static LinkedList<Node> adj[];
	
	static void dijkstra(int start) {
		PriorityQueue<Node> pq =  new PriorityQueue<>();
		pq.add(new Node(start, 0));
		dist[start] = 0;
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			if(visited[now.index]) continue;
			visited[now.index] = true;
			for(Node n : adj[now.index]) {
				if(dist[n.index] > dist[now.index] + n.value) {
					dist[n.index] = dist[now.index] + n.value;
					pq.add(new Node(n.index, dist[n.index]));
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCase = Integer.parseInt(br.readLine());
		for(int t = 0; t<testCase; t++) {
			//Constants Input
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			T = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			S = Integer.parseInt(st.nextToken());
			G = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			
			//Basic Setting
			adj = new LinkedList[N+1];
			dist = new int[N+1];
			visited = new boolean[N+1];
			candidate = new int[T];
			for(int i = 1; i<=N; i++) {
				adj[i] = new LinkedList<Node>();
				dist[i] = INF;
			}
			for(int i = 0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				if((a == G && b == H) || (a == H && b == G))
					v = 2*v - 1;
				else
					v *= 2;
				adj[a].add(new Node(b, v));
				adj[b].add(new Node(a, v));
			}
			for(int i = 0; i<T; i++)
				candidate[i] = Integer.parseInt(br.readLine());
			Arrays.sort(candidate);
			
			dijkstra(S);
			
			for(int i = 0; i<T; i++) {
				if(dist[candidate[i]] % 2 != 0)
					bw.write(candidate[i] + " ");
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	static class Node implements Comparable<Node>{
		int index;
		int value;
		Node(int index, int value){
			this.index = index;
			this.value = value;
		}
		@Override
		public int compareTo(Node n) {
			return this.value - n.value;
		}
	}
}
