import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class TempClass {
	static int V, E, dp[], INF = 10000000;
	static StringTokenizer st;
	static LinkedList<Node> adj[];
	static boolean visited[];
	
	static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		dp[start] = 0;
		pq.add(new Node(start, 0));
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			if(visited[now.end]) continue;
			visited[now.end] = true;
			for(Node n : adj[now.end]) {
				//dijkstra 알고리즘의 핵심
				if(dp[n.end] > dp[now.end] + n.value) {
					dp[n.end] = dp[now.end] + n.value;
					pq.add(new Node(n.end, dp[n.end]));
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(br.readLine());
		
		//Input 및 초기화 작업
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		adj = new LinkedList[V+1];
		visited = new boolean[V+1];
		dp = new int[V+1];
		for(int i = 1; i<=V; i++){
			dp[i] = INF;
			adj[i] = new LinkedList<Node>();
		}
		int start = Integer.parseInt(br.readLine());
		for(int i = 0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			adj[s].add(new Node(e, v));
		}
		
		dijkstra(start);
		for(int i = 1; i<=V; i++) {
			bw.write(((dp[i] >= INF)? "INF" : dp[i]) + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	static class Node implements Comparable<Node>{
		int end;
		int value;
		Node(int end, int value){
			this.end = end;
			this.value = value;
		}
		//PriorityQueue에서 사용하기 위해 compareTo method overriding처리
		@Override
		public int compareTo(Node n) { 
			return this.value - n.value;
		}
	}
}
