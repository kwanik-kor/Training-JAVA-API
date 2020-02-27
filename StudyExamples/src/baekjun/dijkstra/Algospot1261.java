package baekjun.dijkstra;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Algospot1261 {
	static int N, M;
	static int map[][], dist[][];
	static final int INF = 1000000000;
	static int x[] = {1, 0, -1, 0};
	static int y[] = {0, 1, 0, -1};
	static StringTokenizer st;
	
	static void bfs() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(1, 1, 0));
		dist[1][1] = 0;
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			if(now.x == N && now.y == M) return;
			for(int i = 0; i<4; i++) {
				int nx = now.x + x[i];
				int ny = now.y + y[i];
				if(nx > 0 && nx <= N && ny > 0 && ny <= M) {
					if(dist[nx][ny] > dist[now.x][now.y] + map[nx][ny]) {
						dist[nx][ny] = dist[now.x][now.y] + map[nx][ny];
						pq.add(new Node(nx, ny, dist[nx][ny]));
					}
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N+1][M+1];
		dist = new int[N+1][M+1];
		for(int i = 1; i<=N; i++) {
			String s = br.readLine();
			for(int j = 1; j<=M; j++) {
				map[i][j] = s.charAt(j-1) - '0';
				dist[i][j] = INF;
			}
		}
		bfs();
		bw.write(dist[N][M] + "");
		bw.flush();
		bw.close();
		br.close();
	}
	
	static class Node implements Comparable<Node>{
		int x;
		int y;
		int cost;
		public Node(int x, int y, int cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;
		}
		@Override
		public int compareTo(Node n) {
			return this.cost - n.cost;
		}
	}
}
