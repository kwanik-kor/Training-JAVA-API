package baekjun.dijkstra;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class HideAndSeek6118 {
	static int N, M;
	static boolean visit[];
	static List<Integer>[] adj;
	static StringTokenizer st;
	static int num = 2, maxDist = -1, cnt = 1;
	
	static void bfs() {
		Queue<Node> q = new LinkedList<Node>();
		q.add(new Node(1, 0));
		visit[1] = true;
		while(!q.isEmpty()) {
			Node now = q.poll();
			if(maxDist < now.val) {
				maxDist = now.val;
				cnt = 1;
				num = now.idx;
			}else if(maxDist == now.val) {
				cnt++;
				num = Math.min(num, now.idx);
			}
			
			for(Integer next : adj[now.idx]) {
				if(visit[next]) continue;
				visit[next] = true;
				q.add(new Node(next, now.val + 1));
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		adj = new ArrayList[N+1];
		visit = new boolean[N+1];
		for(int i = 1; i<=N; i++)
			adj[i] = new ArrayList<>();
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			adj[v1].add(v2);
			adj[v2].add(v1);
		}
		bfs();
		bw.write(num + " " + maxDist + " " + cnt);
		bw.flush();
		bw.close();
		br.close();
	}
	
	static class Node{
		int idx;
		int val;
		public Node(int idx, int val) {
			this.idx = idx;
			this.val = val;
		}
	}
}
