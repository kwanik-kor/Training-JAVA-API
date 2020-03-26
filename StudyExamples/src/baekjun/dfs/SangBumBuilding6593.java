package baekjun.dfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SangBumBuilding6593 {
	static int L, R, C;
	static int[][][] map;
	static int[] dz = {0, 0, 0, 0, 1, -1};
	static int[] dy = {1, 0, -1, 0, 0, 0};
	static int[] dx = {0, 1, 0, -1, 0, 0};
	static Point SangBum;
	static Point Escape;
	static String Impossible = "Trapped!\n";
	
	static void bfs() {
		Queue<Point> q = new LinkedList<Point>();
		q.add(SangBum);
		while(!q.isEmpty()) {
			Point now = q.poll();
			int z = now.floor;
			int y = now.y;
			int x = now.x;
			if(z == Escape.floor && y == Escape.y && x == Escape.x)
				break;
			for(int dir = 0; dir<6; dir++) {
				int nz = z + dz[dir];
				int ny = y + dy[dir];
				int nx = x + dx[dir];
				if(nz < 0 || ny < 0 || nx < 0 || nz >= L || ny >= R || nx >= C || map[nz][ny][nx] != 0) continue;
				map[nz][ny][nx] = map[z][y][x] + 1;
				q.add(new Point(nz, ny, nx));
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String s = "";
		while(!(s = br.readLine()).equals("0 0 0")) {
			StringTokenizer st = new StringTokenizer(s);
			L = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			map = new int[L][R][C];
			for(int i = 0; i<L; i++) {
				for(int j = 0; j<R; j++) {
					String tmp = br.readLine();
					for(int k = 0; k<C; k++) {
						char c = tmp.charAt(k);
						if(c == 'S'){
							SangBum = new Point(i, j, k);
							map[i][j][k] = 1;
						}
						else if(c == '.')
							map[i][j][k] = 0;
						else if(c == '#')
							map[i][j][k] = -1;
						else {
							Escape = new Point(i, j, k);
							map[i][j][k] = 0;
						}
					}
				}
				br.readLine();
			}
			bfs();
			int ans = map[Escape.floor][Escape.y][Escape.x];
			bw.write((ans == 0)?Impossible : String.format("Escaped in %d minute(s).\n", ans - 1));
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	static class Point{
		int floor;
		int y;
		int x;
		public Point(int floor, int y, int x) {
			this.floor = floor;
			this.y = y;
			this.x = x;
		}
	}
}
