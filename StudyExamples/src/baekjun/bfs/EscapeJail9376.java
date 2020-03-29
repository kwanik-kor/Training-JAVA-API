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
	static char[][] map;
	static int[][][] dist;
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	static ArrayList<Point> prisoner;
	
	static void bfs() {
		prisoner.add(new Point(0, 0));
		for(int k = 0; k<3; k++) {
			Queue<Point> q = new LinkedList<>();
			Point p = prisoner.get(k);
			q.add(p);
			dist[p.y][p.x][k] = 0;
			while(!q.isEmpty()) {
				Point now = q.poll();
				for(int dir = 0; dir < 4; dir++) {
					int ny = now.y + dy[dir];
					int nx = now.x + dx[dir];
					if(ny < 0 || nx < 0 || ny >= h + 2 || nx >= w + 2) continue;
					if(dist[ny][nx][k] >= 0 || map[ny][nx] == '*') continue;
					if(map[ny][nx] == '.') 
						dist[ny][nx][k] = dist[now.y][now.x][k];
					else if(map[ny][nx] == '#')
						dist[ny][nx][k] = dist[now.y][now.x][k] + 1;
					q.add(new Point(ny, nx));
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCase = Integer.parseInt(br.readLine());
		while(testCase-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			map = new char[h+2][w+2];
			dist = new int[h+2][w+2][3];
			prisoner = new ArrayList<Point>();
			for(int i = 0; i<h+2; i++) {
				String str = "";
				if(i >= 1 && i <= h)
					str = br.readLine();
				for(int j = 0; j<w+2; j++) {
					Arrays.fill(dist[i][j], -1);
					if(i == 0 || j == 0 || i == h+1 || j == w+1) map[i][j] = '.';
					else map[i][j] = str.charAt(j - 1);
					if(map[i][j] == '$') {
						map[i][j] = '.';
						prisoner.add(new Point(i, j));
					}
				}
			}
			bfs();
			int ans = 987654321;
			for(int i = 0; i<h+2; i++) {
				for(int j = 0; j<w+2; j++) {
					if(map[i][j] == '*') continue;
					int k = dist[i][j][0] + dist[i][j][1] + dist[i][j][2];
					if(map[i][j] == '#') k -= 2;
					ans = Math.min(ans, k);
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
