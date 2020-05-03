package baekjun.dijkstra;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Zelda4485 {
	static final int INF = 987654321;
	static int N;
	static int map[][], dist[][];
	static int dy[] = {-1, 0, 1, 0};
	static int dx[] = {0, 1, 0, -1};
	
	static int dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		dist[0][0] = map[0][0];
		pq.add(new Node(0, 0, map[0][0]));
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			if(dist[now.y][now.x] < now.val)
				continue;
			for(int dir = 0; dir<4; dir++) {
				int ny = now.y + dy[dir];
				int nx = now.x + dx[dir];
				if(ny < 0 || nx < 0 || ny >= N || nx >= N) continue;
				if(dist[ny][nx] > dist[now.y][now.x] + map[ny][nx]) {
					dist[ny][nx] = dist[now.y][now.x] + map[ny][nx];
					pq.add(new Node(ny, nx, dist[ny][nx]));
				}
			}
		}
		return dist[N-1][N-1];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int prob = 1;
		while((N = Integer.parseInt(br.readLine())) != 0) {
			map = new int[N][N];
			dist = new int[N][N];
			for(int i = 0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					dist[i][j] = INF;
				}
			}
			bw.write(String.format("Problem %d: %d\n", prob++, dijkstra()));
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	static class Node implements Comparable<Node>{
		int y;
		int x;
		int val;
		public Node(int y, int x, int val) {
			this.y = y;
			this.x = x;
			this.val = val;
		}
		@Override
		public int compareTo(Node n) {
			return this.val - n.val;
		}
	}

}
