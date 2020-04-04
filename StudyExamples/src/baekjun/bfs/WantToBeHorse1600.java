package baekjun.bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class WantToBeHorse1600 {
	static int K, H, W;
	static int dy[] = {-1, 0, 1, 0};
	static int dx[] = {0, 1, 0, -1};
	static int knight_y[] = {-2, -2, -1, 1, 2, 2, -1, 1};
	static int knight_x[] = {-1, 1, 2, 2, -1, 1, -2, -2};
	static int[][] map;
	static boolean[][][] visit;
	
	static int bfs() {
		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(0, 0, 0, 0));
		visit[0][0][K] = true;
		while(!q.isEmpty()) {
			Point now = q.poll();
			if(now.y == H-1 && now.x == W-1)
				return now.cnt;
			//말처럼 이동할 기회가 있다면
			if(now.knight < K) {
				for(int dir = 0; dir<8; dir++) {
					int ny = now.y + knight_y[dir];
					int nx = now.x + knight_x[dir];
					if(ny < 0 || nx < 0 || ny >= H || nx >= W || visit[ny][nx][now.knight + 1] || map[ny][nx] == 1) continue;
					visit[ny][nx][now.knight + 1] = true;
					q.add(new Point(ny, nx, now.knight + 1, now.cnt + 1));
				}
			}
			for(int dir = 0; dir<4; dir++) {
				int ny = now.y + dy[dir];
				int nx = now.x + dx[dir];
				if(ny < 0 || nx < 0 || ny >= H || nx >= W || visit[ny][nx][now.knight] || map[ny][nx] == 1) continue;
				visit[ny][nx][now.knight] = true;
				q.add(new Point(ny, nx, now.knight, now.cnt + 1));
			}
		}
		return -1;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H][W];
		visit = new boolean[H][W][K+1];
		for(int i = 0; i<H; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<W; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		System.out.println(bfs());
	}
	
	static class Point{
		int y;
		int x;
		int knight;
		int cnt;
		public Point(int y, int x, int knight, int cnt) {
			this.y = y;
			this.x = x;
			this.knight = knight;
			this.cnt = cnt;
		}
	}
}
