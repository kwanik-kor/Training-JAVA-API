package baekjun.bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class MoonIsRising1194 {
	static int N, M;
	static int dy[] = {-1, 0, 1, 0};
	static int dx[] = {0, 1, 0, -1};
	static char[][] map;
	static boolean[][][] visit;
	static Point MINSIK;
	static ArrayList<Point> exit;
	
	static int bfs() {
		Queue<Point> q = new LinkedList<Point>();
		visit[0][MINSIK.y][MINSIK.x] = true;
		q.add(MINSIK);
		while(!q.isEmpty()) {
			Point now = q.poll();
			if(map[now.y][now.x] == '1')
				return now.cnt;
			for(int dir = 0; dir<4; dir++) {
				int ny = now.y + dy[dir];
				int nx = now.x + dx[dir];
				if(ny < 0 || nx < 0 || ny >= N || nx >= M || visit[now.key][ny][nx] || map[ny][nx] == '#') continue;
				if(map[ny][nx] == '.' || map[ny][nx] == '0' || map[ny][nx] == '1') {
					visit[now.key][ny][nx] = true;
					q.add(new Point(ny, nx, now.cnt + 1, now.key));
				}else if(map[ny][nx] >= 'a' && map[ny][nx] <= 'f') {
					int newkey = now.key | (int)(1 << (map[ny][nx]-'a'));
					visit[newkey][ny][nx] = true;
					q.add(new Point(ny, nx, now.cnt + 1, newkey));
				}else if(map[ny][nx] >= 'A' && map[ny][nx] <= 'F') {
					if((now.key & (1 << (int)(map[ny][nx]-'A'))) != 0) {
						visit[now.key][ny][nx] = true;
						q.add(new Point(ny, nx, now.cnt + 1, now.key));
					}
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		visit = new boolean[64][N][M];
		for(int i = 0; i<N; i++) {
			String str = br.readLine();
			for(int j = 0; j<M; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == '0')
					MINSIK = new Point(i, j, 0, 0);
			}
		}
		bw.write(bfs() + "");
		bw.flush();
		bw.close();
		br.close();
	}
	
	static class Point{
		int y;
		int x;
		int cnt;
		int key;
		public Point(int y, int x, int cnt, int key) {
			this.y = y;
			this.x = x;
			this.cnt = cnt;
			this.key = key;
		}
	}

}
