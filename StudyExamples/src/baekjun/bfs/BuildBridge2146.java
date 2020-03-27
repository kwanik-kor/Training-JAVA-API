package baekjun.bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BuildBridge2146 {
	static int N;
	static int[][] map;
	static int[][] island;
	static int[][] dis;
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	
	static void seperateIsland(int y, int x, int num) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(y, x));
		island[y][x] = num;
		while(!q.isEmpty()) {
			Point now = q.poll();
			for(int dir = 0; dir<4; dir++) {
				int ny = now.y + dy[dir];
				int nx = now.x + dx[dir];
				if(ny < 0 || nx < 0 || ny >= N || nx >= N || island[ny][nx] != 0) continue;
				if(map[ny][nx] == 1) {
					island[ny][nx] = num;
					q.add(new Point(ny, nx));
				}
			}
		}
	}
	
	static void extendIsland() {
		Queue<Point> q = new LinkedList<>();
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				if(map[i][j] == 1) {
					q.offer(new Point(i, j));
					dis[i][j] = 0;
				}else
					dis[i][j] = -1;
			}
		}
		while(!q.isEmpty()) {
			Point now = q.poll();
			for(int dir = 0; dir<4; dir++) {
				int ny = now.y + dy[dir];
				int nx = now.x + dx[dir];
				if(ny < 0 || nx < 0 || ny >= N || nx >= N) continue;
				if(dis[ny][nx] == -1) {
					dis[ny][nx] = dis[now.y][now.x] + 1;
					island[ny][nx] = island[now.y][now.x];
					q.add(new Point(ny, nx));
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		island = new int[N][N];
		dis = new int[N][N];
		for(int i = 0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j<N; j++) 
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		int num = 0;
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				if(map[i][j] == 1 && island[i][j] == 0)
					seperateIsland(i, j, ++num);
			}
		}
		extendIsland();
		int ans = -1;
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				for(int dir = 0; dir<4; dir++) {
					int ny = i + dy[dir];
					int nx = j + dx[dir];
					if(ny < 0 || nx < 0 || ny >= N || nx >= N) continue;
					if(island[i][j] != island[ny][nx]) {
						if(ans == -1 || ans > dis[i][j] + dis[ny][nx])
							ans = dis[i][j] + dis[ny][nx];
					}
				}
			}
		}
		bw.write(ans + "");
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
