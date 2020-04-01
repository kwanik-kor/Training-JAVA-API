package baekjun.bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class AlmostShortest5719 {
	//dijkstra로 최단 경로를 찾고 최단 경로인 경우를 지운다. 이후 다시 최단경로를 구한다.
	static int start, end;
	static final int INF = 987654321;
	static int[] dist;
	static boolean[] visit;
	static ArrayList<Node> adj[], path[];
	static StringTokenizer st;
	
	static void dijkstra() {
		Arrays.fill(visit, false);
		Arrays.fill(dist, INF);
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		pq.add(new Node(start, 0));
		dist[start] = 0;
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			if(visit[now.idx]) continue;
			visit[now.idx] = true;
			for(Node next : adj[now.idx]) {
				if(next.val == -1) continue;
				if(dist[next.idx] > dist[now.idx] + next.val) {
					dist[next.idx] = dist[now.idx] + next.val;
					pq.add(new Node(next.idx, dist[next.idx]));
					path[next.idx].clear();
					path[next.idx].add(new Node(now.idx, dist[next.idx]));
				}else if(dist[next.idx] == dist[now.idx] + next.val)
					path[next.idx].add(new Node(now.idx, dist[next.idx]));
			}
		}
	}
	
	static void bfs() {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(end);
		while(!q.isEmpty()) {
			int now = q.poll();
			for(Node n1 : path[now]) {
				int neighbor = n1.idx;
				for(Node n2 : adj[neighbor]) {
					if(n2.idx == now)
						n2.val = -1;
				}
				q.add(neighbor);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = "";
		while(!(str = br.readLine()).equals("0 0")) {
			//N,M 입력 및 배열 초기화
			st = new StringTokenizer(str);
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			dist = new int[N];
			visit = new boolean[N];
			adj = new ArrayList[N];
			path = new ArrayList[N];
			for(int i = 0; i<N; i++) {
				adj[i] = new ArrayList<Node>();
				path[i] = new ArrayList<Node>();
			}
			
			//S, D, 도로 입력
			st = new StringTokenizer(br.readLine());
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			for(int i = 0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				adj[a].add(new Node(b, c));
			}
			
			dijkstra();
			bfs();
			dijkstra();
			
			bw.write((dist[end] == INF)? "-1\n" : dist[end] + "\n");
		}
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
