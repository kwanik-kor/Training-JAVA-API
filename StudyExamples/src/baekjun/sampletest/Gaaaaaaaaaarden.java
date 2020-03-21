package baekjun.sampletest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Gaaaaaaaaaarden {
	static int N, M, G, R;
	static int INF = 987654321;
	static int[][] map;
	static char[][] colorMap;
	static int dy[] = {1, 0, -1, 0};
	static int dx[] = {0, 1, 0, -1};
	static ArrayList<Point> pos = new ArrayList<Point>();
	static int maxCnt;
	
	static void bfs() {
		int flower = 0;
		Queue<Point> q = new LinkedList<Point>();
		for(Point p : pos){
			if(p.c != 'N')
				q.add(p);
		}
		while(!q.isEmpty()) {
			Point now = q.poll();
			colorMap[now.y][now.x] = now.c;
			for(int i = 0; i<4; i++) {
				int ny = now.y + dy[i];
				int nx = now.x + dx[i];
				if(ny >= 0 && nx >= 0 && ny < N && nx < M && map[ny][nx] != -1 && colorMap[ny][nx] != 'L') {
					if(colorMap[ny][nx] != now.c && map[ny][nx] == now.dist + 1)
						flower++;
					else {
						colorMap[ny][nx] = now.c;
						map[ny][nx] = now.dist + 1;
						q.add(new Point(ny, nx, map[ny][nx], now.c));
					}
				}
			}
		}
		maxCnt = Math.max(maxCnt, flower);
	}
	
	static void selectGreen(int cnt) {
		if(cnt == G){
			selectRed(0);
			return;
		}
		for(int i = 0; i<pos.size(); i++) {
			if(pos.get(i).c == 'N') {
				pos.get(i).c = 'G';
				selectGreen(cnt + 1);
				pos.get(i).c = 'N';
			}
		}
	}
	
	static void selectRed(int cnt) {
		if(cnt == R) {
			bfs();
			return;
		}
		for(int i = 0; i<pos.size(); i++) {
			if(pos.get(i).c == 'N') {
				pos.get(i).c = 'R';
				selectRed(cnt + 1);
				pos.get(i).c = 'N';
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		colorMap = new char[N][M];
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) {
					pos.add(new Point(i, j, 0, 'N'));
					map[i][j] = -1;
				}else if(map[i][j] == 1) {
					map[i][j] = 0;
					colorMap[i][j] = 'N';
				}
				else {
					map[i][j] = -1;
					colorMap[i][j] = 'L';
				}
			}
		}
		selectGreen(0);
		System.out.println(maxCnt);
	}
	
	static class Point{
		int y;
		int x;
		int dist;
		char c;
		public Point(int y, int x, int dist, char c) {
			this.y = y;
			this.x = x;
			this.c = c;
			this.dist = dist;
		}
	}
}
