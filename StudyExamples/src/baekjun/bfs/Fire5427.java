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

public class Fire5427 {
	static int w, h;
	static int EMPTY = 0;
	static int MAN = 1;
	static int FIRE = 2;
	static char map[][] = new char[1001][1001];
	static int dy[] = {1, 0, -1, 0};
	static int dx[] = {0, 1, 0, -1};
	static Point SangGeun;
	static Point[][] state;
	static ArrayList<Point> fire;
	static int minEscape;
	static int INF = 987654321;
	
	static void bfs() {
		state = new Point[h][w];
		for(int i = 0; i<h; i++) {
			for(int j = 0; j<w; j++)
				state[i][j] = new Point();
		}
		
		Queue<Point> q = new LinkedList<Point>();
		state[SangGeun.y][SangGeun.x] = new Point(0, MAN);
		q.add(SangGeun);
		for(Point p : fire) {
			state[p.y][p.x] = new Point(0, FIRE);
			q.add(p);
		}
		
		while(!q.isEmpty()) {
			Point cur = q.poll();
			int curtime = state[cur.y][cur.x].y;
			int curstate = state[cur.y][cur.x].x;
			for(int i = 0; i<4; i++) {
				int ny = cur.y + dy[i];
				int nx = cur.x + dx[i];
				if(ny < 0 || nx < 0 || ny >= h || nx >= w) {
					if(curstate == MAN)
						minEscape = Math.min(minEscape, curtime + 1);
					continue;
				}
				if(map[ny][nx] == '#') continue;
				if(state[ny][nx].x == FIRE) continue;
				if(state[ny][nx].x == EMPTY || state[ny][nx].x == MAN) {
					state[ny][nx] = new Point(curtime + 1, curstate);
					q.add(new Point(ny, nx));
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCase = Integer.parseInt(br.readLine());
		for(int t = 0; t<testCase; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			minEscape = INF;
			fire = new ArrayList<Point>();
			for(int i = 0; i<h; i++) {
				String tmp = br.readLine();
				for(int j = 0; j<w; j++) {
					map[i][j] = tmp.charAt(j);
					if(map[i][j] == '@')
						SangGeun = new Point(i, j);
					else if(map[i][j] == '*')
						fire.add(new Point(i, j));
				}
			}
			bfs();
			bw.write((minEscape == 987654321)? "IMPOSSIBLE\n" : minEscape + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	static class Point{
		int y;
		int x;
		public Point() {
			this.y = 0;
			this.x = 0;
		}
		public Point(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}
