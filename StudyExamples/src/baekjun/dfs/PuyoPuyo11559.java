package baekjun.dfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class PuyoPuyo11559 {
	static int ans = 0;
	static ArrayList<Point> list = new ArrayList<Point>();
	static char[][] map = new char[12][6];
	static boolean[][] visited = new boolean[12][6];
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	
	static void fallPuyo() {
		for(int x = 0; x<6; x++) {
			for(int y = 11; y>=0; y--) {
				if(map[y][x] == '.') {
					for(int i = y - 1; i>=0; i--) {
						if(map[i][x] != '.') {
							char tmp = map[y][x];
							map[y][x] = map[i][x];
							map[i][x] = tmp;
							break;
						}
					}
				}
			}
		}
	}
	
	static void bfs(int y, int x) {
		Queue<Point> q = new LinkedList<Point>();
		q.offer(new Point(y, x));
		list.add(new Point(y, x));
		visited[y][x] = true;
		char c = map[y][x];
		while(!q.isEmpty()) {
			Point now = q.poll();
			for(int dir = 0; dir<4; dir++) {
				int ny = now.y + dy[dir];
				int nx = now.x + dx[dir];
				if(ny < 0 || nx < 0 || ny >= 12 || nx >= 6 || visited[ny][nx] || map[ny][nx] != c) continue;
				list.add(new Point(ny, nx));
				q.offer(new Point(ny, nx));
				visited[ny][nx] = true;
			}
		}
	}
	
	static void solve() {
		while(true) {
			boolean flag = false;
			for(int i = 0; i<12; i++)
				Arrays.fill(visited[i], false);
			for(int i = 0; i<12; i++) {
				for(int j = 0; j<6; j++) {
					if(!visited[i][j] && map[i][j] != '.')
						bfs(i, j);
					if(list.size() >= 4) {
						for(Point p : list)
							map[p.y][p.x] = '.';
						flag = true;
					}
					list.clear();
				}
			}
			if(flag) {
				ans++;
				fallPuyo();
			}
			else break;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i = 0; i<12; i++) {
			String str = br.readLine();
			for(int j = 0; j<6; j++)
				map[i][j] = str.charAt(j);
		}
		solve();
		bw.write(ans + "");
		bw.flush();
		bw.close();
		br.close();
	}
	
	static class Point {
		int y;
		int x;
		public Point(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}
