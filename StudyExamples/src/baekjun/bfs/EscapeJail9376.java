package baekjun.bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class EscapeJail9376 {
	static int h, w;
	static char map[][];
	static int dist[][][];
	static int dy[] = {-1, 0, 1, 0};
	static int dx[] = {0, 1, 0, -1};
	static ArrayList<Point> list;
	
	static void bfs() {
		for(int i = 0; i<3; i++) {
			Queue<Point> q = new LinkedList<Point>();
			Point p = list.get(i);
			dist[p.y][p.x][i] = 0;
			q.add(p);
			while(!q.isEmpty()) {
				Point now = q.poll();
				for(int dir = 0; dir<4; dir++) {
					int ny = now.y + dy[dir];
					int nx = now.x + dx[dir];
					if(ny < 0 || ny >= h+2 || nx < 0 || nx >= w+2) continue;
					if(map[ny][nx] == '*') continue;
					if(map[ny][nx] == '.' && (dist[ny][nx][i] == -1 || dist[ny][nx][i] > dist[now.y][now.x][i])) {
						dist[ny][nx][i] = dist[now.y][now.x][i];
						q.add(new Point(ny, nx));
					}if(map[ny][nx] == '#' && (dist[ny][nx][i] == -1 || dist[ny][nx][i] > dist[now.y][now.x][i] + 1)) {
						dist[ny][nx][i] = dist[now.y][now.x][i] + 1;
						q.add(new Point(ny, nx));
					}
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			map = new char[h+2][w+2];
			list = new ArrayList<Point>();
			list.add(new Point(0, 0));
			dist = new int[h+2][w+2][3];
			for(int i = 0; i<h+2; i++) {
				String tmp = "";
				if(1 <= i && i <= h)
					tmp = br.readLine();
				for(int j = 0; j<w+2; j++) {
					Arrays.fill(dist[i][j], -1);
					if(i == 0 || i == h+1 || j == 0 || j == w+1) {
						map[i][j] = '.';
						continue;
					}
					map[i][j] = tmp.charAt(j - 1);
					if(map[i][j] == '$') {
						map[i][j] = '.';
						list.add(new Point(i, j));
					}
				}
			}
			bfs();
			int ans = 987654321;
			for(int i = 0; i<h+2; i++) {
				for(int j = 0; j<w+2; j++) {
					if(map[i][j] == '*') continue;
					int tmp = dist[i][j][0] + dist[i][j][1] + dist[i][j][2];
					if(map[i][j] == '#')
						tmp -= 2;
					ans = Math.min(ans, tmp);
				}
			}
			bw.write(ans + "\n");
		}
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
