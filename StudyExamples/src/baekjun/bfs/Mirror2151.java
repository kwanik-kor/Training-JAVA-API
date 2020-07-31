package baekjun.bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class Mirror2151 {
	static int N;
	//ºÏ µ¿ ³² ¼­
	static int dy[] = {-1, 0, 1, 0};
	static int dx[] = {0, 1, 0, -1};
	static int refraction[][] = {{1, 3}, {0, 2}, {1, 3}, {0, 2}};
	static boolean visit[][][] = new boolean[51][51][4];
	static char map[][] = new char[51][51];
	static Point door[] = new Point[2];
	
	static int bfs() {
		PriorityQueue<Point> pq = new PriorityQueue<Point>();
		for(int dir = 0; dir<4; dir++)
			pq.add(new Point(door[0].y, door[0].x, dir, 0));
		
		while(!pq.isEmpty()) {
			Point now = pq.poll();
			visit[now.y][now.x][now.dir] = true;
			
			if(now.y == door[1].y && now.x == door[1].x) {
				return now.cnt;
			}
			int ny = now.y + dy[now.dir];
			int nx = now.x + dx[now.dir];
			if(ny < 0 || nx < 0 || ny >= N || nx >= N || visit[ny][nx][now.dir] || map[ny][nx] == '*') continue;
			if(map[ny][nx] == '!') {
				pq.add(new Point(ny, nx, refraction[now.dir][0], now.cnt + 1));
				pq.add(new Point(ny, nx, refraction[now.dir][1], now.cnt + 1));
			}
			pq.add(new Point(ny, nx, now.dir, now.cnt));
			
		}
		
		return 0;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		for(int i = 0; i<N; i++) {
			map[i] = br.readLine().toCharArray();
			for(int j = 0; j<N; j++) {
				if(map[i][j] == '#' && door[0] == null) 
					door[0] = new Point(i, j, 0, 0);
				else if(map[i][j] == '#' && door[0] != null)
					door[1] = new Point(i, j, 0, 0);
			}
		}
		bw.write(String.valueOf(bfs()));
		bw.flush();
		bw.close();
		br.close();
	}
	
	static class Point implements Comparable<Point> {
		int y;
		int x;
		int dir;
		int cnt;
		
		public Point(int y, int x, int dir, int cnt) { 
			this.y = y;
			this.x = x;
			this.dir = dir;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Point p) {
			return this.cnt - p.cnt;
		}
	}
}
