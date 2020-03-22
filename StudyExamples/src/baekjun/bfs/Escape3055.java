package baekjun.bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Escape3055 {
	static int R, C;
	static int INF = 987654321;
	static char[][] map;
	static int[] dy = {0, 1, 0, -1};
	static int[] dx = {1, 0, -1, 0};
	static Queue<Point> hedgehog = new LinkedList<Point>();
	static Queue<Point> water = new LinkedList<Point>();
	
	static int bfs() {
		int cnt = 0;
		while(true) {
			cnt++;
			
			int watersz = water.size();
			for(int i = 0; i<watersz; i++) {
				Point cur = water.poll();
				for(int dir = 0; dir<4; dir++) {
					int ny = cur.y + dy[dir];
					int nx = cur.x + dx[dir];
					if(ny >= 0 && nx >= 0 && ny < R && nx < C && map[ny][nx] == '.') {
						map[ny][nx] = '*';
						water.add(new Point(ny, nx));
					}
				}
			}
			
			int hedge = hedgehog.size();
			if(hedge == 0) return INF;
			
			for(int i = 0; i<hedge; i++) {
				Point cur = hedgehog.poll();
				for(int dir = 0; dir<4; dir++) {
					int ny = cur.y + dy[dir];
					int nx = cur.x + dx[dir];
					if(ny >= 0 && nx >= 0 && ny < R && nx < C) {
						if(map[ny][nx] == 'D') return cnt;
						if(map[ny][nx] == '.') {
							map[ny][nx] = 'S';
							hedgehog.add(new Point(ny, nx));
						}
					}
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		for(int i = 0; i<R; i++) {
			String str = br.readLine();
			for(int j = 0; j<C; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == 'S')
					hedgehog.add(new Point(i, j));
				if(map[i][j] == '*')
					water.add(new Point(i, j));
			}
		}
		int ret = bfs();
		bw.write((ret == INF)? "KAKTUS" : ret + "");
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
