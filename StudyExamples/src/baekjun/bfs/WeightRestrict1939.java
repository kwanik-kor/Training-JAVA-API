package baekjun.bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class WeightRestrict1939 {
	static int N, M, start, end;
	static int maxWeight;
	static boolean visit[];
	static LinkedList<Node> adj[];
	
	static boolean bfs(int w) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		visit[start] = true;
		while(!q.isEmpty()) {
			int now = q.poll();
			if(now == end)
				return true;
			for(Node n : adj[now]) {
				if(visit[n.idx]) continue;
				if(n.val >= w) {
					visit[n.idx] = true;
					q.add(n.idx);
				}
			}
		}
		return false;
	}
	
	static int solve() {
		int left = 0;
		int right = maxWeight;
		while(left <= right) {
			visit = new boolean[N+1];
			int mid = (left + right)/2;
			if(bfs(mid))
				left = mid + 1;
			else
				right = mid - 1;
		}
		return right;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		adj = new LinkedList[N+1];
		for(int i = 1; i<=N; i++)
			adj[i] = new LinkedList<Node>();
		while(M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			adj[a].add(new Node(b, c));
			adj[b].add(new Node(a, c));
			maxWeight = Math.max(maxWeight, c);
		}
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		bw.write(solve() + "");
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
