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

public class Iceburg2573 {
	static int N, M;
	static int[][] map;
	static int[][] ocean;
	static int[][] piece;
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	static ArrayList<Point> iceburg = new ArrayList<>();
	
	static void bfs(int y, int x, int num) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(y, x));
		while(!q.isEmpty()) {
			Point now = q.poll();
			for(int i = 0; i<4; i++) {
				int ny = now.y + dy[i];
				int nx = now.x + dx[i];
				if(ny < 0 || nx < 0 || ny >= N || nx >= M) continue;
				if(map[ny][nx] != 0 && piece[ny][nx] == 0) {
					piece[ny][nx] = num;
					q.add(new Point(ny, nx));
				}
			}
		}
	}
	
	static void getOcean() {
		for(Point p : iceburg) {
			int cnt = 0;
			for(int i = 0; i<4; i++) {
				int ny = p.y + dy[i];
				int nx = p.x + dx[i];
				if(ny < 0 || nx < 0 || ny >= N || nx >= M) continue;
				if(map[ny][nx] == 0)
					cnt++;
			}
			ocean[p.y][p.x] = cnt;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		ocean = new int[N][M];
		piece = new int[N][M];
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<M; j++) 
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		int year = 0;
		while(true) {
			year++;
			iceburg = new ArrayList<>();
			for(int i = 0; i<N; i++)
				for(int j = 0; j<M; j++)
					if(map[i][j] != 0)
						iceburg.add(new Point(i, j));
			if(iceburg.size() == 0) {
				year = 0;
				break;
			}
			getOcean();
			for(Point p : iceburg) {
				map[p.y][p.x] -= ocean[p.y][p.x];
				if(map[p.y][p.x] < 0) map[p.y][p.x] = 0;
			}
			for(int i = 0; i<N; i++)
				Arrays.fill(piece[i], 0);
			int num = 0;
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<M; j++) {
					if(map[i][j] != 0 && piece[i][j] == 0)
						bfs(i, j, ++num);
				}
			}
			if(num > 1)
				break;
		}
		bw.write(year + "");
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
