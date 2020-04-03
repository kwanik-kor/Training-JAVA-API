package baekjun.bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class TransferLog1938 {
	static int N;
	static int dy[] = {-1, 0, 1, 0};
	static int dx[] = {0, 1, 0, -1};
	static char[][] map;
	static boolean[][][] visit;
	static Point[] log = new Point[3]; 
	static Point[] end = new Point[3];
	
	static void calcDirection() {
		//가로면 1, 세로면 0
		if(log[0].y == log[1].y && log[1].y == log[2].y) {
			for(Point p : log) 
				p.dir = 1;
		}
		if(end[0].y == end[1].y && end[1].y == end[2].y) {
			for(Point p : end)
				p.dir = 1;
		}
	}
	
	static boolean isPossibleToMove(int y, int x, int dir) {
		if(dir == 0) { //세로모양일 때
			if(y - 1 < 0 || y + 1 >= N || x < 0 || x >= N || visit[y][x][dir]) 
				return false;
			for(int i = y-1; i<=y+1; i++) {
				if(map[i][x] == '1')
					return false;
			}
		}else { //가로모양일 때
			if(y < 0 || y >= N || x - 1 < 0 || x + 1 >= N || visit[y][x][dir])
				return false;
			for(int i = x-1; i<=x+1; i++) {
				if(map[y][i] == '1')
					return false;
			}
		}
		return true;
	}
	
	static boolean isPossibleToRotate(int y, int x, int dir) {
		//세론데 좌우벽에 들러붙어있거나, 가론데 위아래 벽에 들러붙어있으면
		if((dir == 1 && (y == 0 || y == N-1)) || (dir == 0 && (x == 0 || x == N-1))) 
			return false;
		for(int i = y-1; i<=y+1; i++) 
			for(int j = x-1; j<=x+1; j++)
				if(map[i][j] == '1')
					return false;
		return true;
	}
	
	static int bfs() {
		Queue<Point> q = new LinkedList<Point>();
		q.add(log[1]);
		visit[log[1].y][log[1].x][log[1].dir] = true;
		while(!q.isEmpty()) {
			Point now = q.poll();
			if(now.y == end[1].y && now.x == end[1].x && now.dir == end[1].dir)
				return now.cnt;
			for(int dir = 0; dir<4; dir++) {
				int ny = now.y + dy[dir];
				int nx = now.x + dx[dir];
				if(isPossibleToMove(ny, nx, now.dir)) {
					visit[ny][nx][now.dir] = true;
					q.add(new Point(ny, nx, now.cnt + 1, now.dir));
				}
			}
			
			if(isPossibleToRotate(now.y, now.x, now.dir)) {
				int newDir = (now.dir == 0)? 1 : 0;
				if(visit[now.y][now.x][newDir]) continue;
				visit[now.y][now.x][newDir] = true;
				q.add(new Point(now.y, now.x, now.cnt + 1, newDir));
			}
		}
		return 0;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		visit = new boolean[N][N][2];
		int log_idx = 0;
		int end_idx = 0;
		for(int i = 0; i<N; i++) {
			String str = br.readLine();
			for(int j = 0; j<N; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == 'B') {
					log[log_idx] = new Point(i, j, 0, 0);
					log_idx++;
				}else if(map[i][j] == 'E') {
					end[end_idx] = new Point(i, j, 0, 0);
					end_idx++;
				}
			}
		}
		calcDirection();
		bw.write(bfs() + "");
		bw.flush();
		bw.close();
		br.close();
	}
	
	static class Point{
		int y;
		int x;
		int cnt;
		int dir;
		public Point(int y, int x, int cnt, int dir) {
			this.y = y;
			this.x = x;
			this.cnt = cnt;
			this.dir = dir;
		}
	}
}
