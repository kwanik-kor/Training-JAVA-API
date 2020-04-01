package baekjun.bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class LaserCommunication6087 {
	static int W, H;
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	static int[][] cnt;
	static boolean[][] visit;
	static char[][] map;
	static Point start = new Point(-1, -1);
	static Point end = new Point(-1, -1);
	
	static void bfs() {
		Queue<Point> q = new LinkedList<Point>();
		q.add(start);
		visit[start.y][start.x] = true;
		while(!q.isEmpty()) {
			Point now = q.poll();
			for(int dir = 0; dir<4; dir++) {
				int ny = now.y + dy[dir];
				int nx = now.x + dx[dir];
				while(ny >= 0 && ny < H && nx >= 0 && nx < W && map[ny][nx] != '*') {
					if(!visit[ny][nx] || cnt[ny][nx] > cnt[now.y][now.x] + 1) {
						cnt[ny][nx] = cnt[now.y][now.x] + 1;
						visit[ny][nx] = true;
						q.add(new Point(ny, nx));
					}
					ny += dy[dir];
					nx += dx[dir];
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		cnt = new int[H][W];
		visit = new boolean[H][W];
		map = new char[H][W];
		for(int i = 0; i<H; i++) {
			String str = br.readLine();
			for(int j = 0; j<W; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == 'C') {
					if(start.y == -1) start = new Point(i, j);
					else end = new Point(i, j);
				}
			}
		}
		bfs();
		bw.write(cnt[end.y][end.x] - 1 + "");
		bw.flush();
		bw.close();
		br.close();
	}
	
	static class Point{
		int y;
		int x;
		public Point(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}
