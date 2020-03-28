package baekjun.bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class WeightRestrict1939 {
	static int N, M, start, end;
	static LinkedList<Node> adj[];
	static int[] dist;
	static boolean[] visit;
	static int maxCost = 0;
	static final int INF = 1000000001;
	
	static boolean bfs(int w) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		visit[start] = true;
		while(!q.isEmpty()) {
			int now = q.poll();
			if(now == end)
				return true;
			for(Node n : adj[now]) {
				if(!visit[n.idx] && w <= n.val) {
					visit[n.idx] = true;
					q.add(n.idx);
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		adj = new LinkedList[N + 1];
		visit = new boolean[N + 1];
		for(int i = 1; i<=N; i++){
			adj[i] = new LinkedList<Node>();
		}
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			adj[a].add(new Node(b, c));
			adj[b].add(new Node(a, c));
			maxCost = Math.max(maxCost, c);
		}
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		int left = 0;
		int right = maxCost;
		while(left <= right) {
			Arrays.fill(visit, false);
			int mid = (left + right)/2;
			if(bfs(mid))
				left = mid + 1;
			else
				right = mid - 1;
		}
		bw.write(right + "");
		bw.flush();
		bw.close();
		br.close();
	}
	
	static class Node {
		int idx;
		int val;
		public Node(int idx, int val) {
			this.idx = idx;
			this.val = val;
		}
	}
}
