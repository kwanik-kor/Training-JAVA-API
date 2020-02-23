package baekjun.dijkstra;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class MinCost2_11779 {
	static int N, M, dist[][];
	static boolean visited[];
	static LinkedList<Node> adj[];
	static StringTokenizer st;
	static final int INF = 987654321;
	
	static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));
		dist[start][0] = 0;
		dist[start][1] = start;
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			if(visited[now.e]) continue;
			for(Node n : adj[now.e]) {
				if(dist[n.e][0] > dist[now.e][0] + n.v) {
					dist[n.e][0] = dist[now.e][0] + n.v;
					dist[n.e][1] = now.e;
					pq.add(new Node(n.e, dist[n.e][0]));
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		adj = new LinkedList[N+1];
		dist = new int[N+1][2];
		visited = new boolean[N+1];
		for(int i = 1; i<=N; i++) {
			dist[i][0] = INF;
			adj[i] = new LinkedList<Node>();
		}
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			adj[a].add(new Node(b, v));
		}
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		dijkstra(start);
		bw.write(dist[end][0] + "\n");
		int temp = end;
		Stack<Integer> stack = new Stack<>();
		stack.push(end);
		while(temp != start) {
			stack.push(dist[temp][1]);
			temp = dist[temp][1];
		}
		bw.write(stack.size() + "\n");
		while(!stack.isEmpty())
			bw.write(stack.pop() + " ");
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
			return this.v - n.v;
		}
	}
}
