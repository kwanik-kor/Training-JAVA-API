package baekjun.sampletest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Gaaaaaaaaaarden {
	static int N, M, G, R;
	static int EMPTY = 0;
	static int GREEN = 1;
	static int RED = 2;
	static int FLOWER = 3;
	static int[][] map;
	static int[][] cand = new int[10][2];
	static boolean[] visit = new boolean[10];
	static int candsz = 0;
	static int[] chosen_g = new int[5];
	static int[] chosen_r = new int[5];
	static int dy[] = {1, 0, -1, 0};
	static int dx[] = {0, 1, 0, -1};
	static int maxCnt;
	
	static void bfs() {
		int cnt = 0;
		Point[][] state = new Point[N][M];
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++) 
				state[i][j] = new Point();
		}
		
		Queue<Point> q = new LinkedList<Point>();
		for(int i = 0; i<G; i++) {
			state[cand[chosen_g[i]][0]][cand[chosen_g[i]][1]] = new Point(0, GREEN);
			q.add(new Point(cand[chosen_g[i]][0], cand[chosen_g[i]][1]));
		}
		for(int i = 0; i<R; i++) {
			state[cand[chosen_r[i]][0]][cand[chosen_r[i]][1]] = new Point(0, RED);
			q.add(new Point(cand[chosen_r[i]][0], cand[chosen_r[i]][1]));
		}
		
		while(!q.isEmpty()) {
			Point now = q.poll();
			int curtime = state[now.y][now.x].y;
			int curColor = state[now.y][now.x].x;
			if(state[now.y][now.x].x == FLOWER) continue;
			for(int dir = 0; dir<4; dir++) {
				int ny = now.y + dy[dir];
				int nx = now.x + dx[dir];
				if(nx < 0 || ny < 0 || ny >= N || nx >= M) continue;
				if(map[ny][nx] == 0) continue;
				if(state[ny][nx].x == EMPTY) {
					state[ny][nx] = new Point(curtime + 1, curColor);
					q.add(new Point(ny, nx));
				}else if(state[ny][nx].x == RED) {
					if(curColor == GREEN && state[ny][nx].y == curtime + 1) {
						cnt++;
						state[ny][nx].x = FLOWER;
					}
				}else if(state[ny][nx].x == GREEN) {
					if(curColor == RED && state[ny][nx].y == curtime + 1) {
						cnt++;
						state[ny][nx].x = FLOWER;
					}
				}
			}
		}
		maxCnt = Math.max(maxCnt, cnt);
	}
	
	static void selectGreen(int cnt) {
		if(cnt == G){
			selectRed(0);
			return;
		}
		int cur = (cnt == 0)? 0 : chosen_g[cnt-1] + 1;
		for(int i = cur; i<candsz; i++) {
			chosen_g[cnt] = i;
			visit[i] = true;
			selectGreen(cnt + 1);
			visit[i] = false;
		}
	}
	
	static void selectRed(int cnt) {
		if(cnt == R) {
			bfs();
			return;
		}
		int cur = (cnt == 0)? 0 : chosen_r[cnt-1] + 1;
		for(int i = cur; i<candsz; i++) {
			if(visit[i]) continue;
			chosen_r[cnt] = i;
			visit[i] = true;
			selectRed(cnt + 1);
			visit[i] = false;
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
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) {
					cand[candsz][0] = i;
					cand[candsz][1] = j;
					candsz++;
				}
			}
		}
		selectGreen(0);
		bw.write(maxCnt + "");
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
		public Point() {
			this.y = 0;
			this.x = 0;
		}
	}
}
