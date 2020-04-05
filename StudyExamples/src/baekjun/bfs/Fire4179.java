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

public class Fire4179 {
	static int R, C;
	static int ans;
	static int[] dy = {0, 1, 0, -1};
	static int[] dx = {1, 0, -1, 0};
	static char[][] map;
	static int[][] visit;
	static Point jihoon;
	static ArrayList<Point> fire = new ArrayList<Point>();
	
	static void bfs() {
		//ÁöÈÆ Å¥
		Queue<Point> q1 = new LinkedList<Point>();
		q1.add(jihoon);
		//ºÒ Å¥
		Queue<Point> q2 = new LinkedList<Point>();
		for(Point p : fire)
			q2.add(p);
		
		while(!q1.isEmpty() || !q2.isEmpty()) {
			int size1 = q1.size();
			boolean flag = false;
			if(size1 > 0) {
				while(size1-- > 0) {
					Point now = q1.poll();
					for(int dir = 0; dir<4; dir++) {
						int ny = now.y + dy[dir];
						int nx = now.x + dx[dir];
						if(ny == 1 || nx == 1 || ny == R+1 || nx == C+1) {
							//Å»Ãâ
							ans = visit[now.y][now.x];
							flag = true;
							break;
						}
						if(visit[ny][nx] == -1) continue;
						visit[ny][nx] = visit[now.y][now.x] + 1;
						q1.add(new Point(ny, nx));
					}
					if(flag) break;
				}
				if(flag) break;
			}else {
				ans = -1;
				break;
			}
			
			int size2 = q2.size();
			if(size2 > 0) {
				while(size2-- > 0) {
					Point now = q2.poll();
					for(int dir = 0; dir<4; dir++) {
						int ny = now.y + dy[dir];
						int nx = now.x + dx[dir];
						if(ny < 1 || nx < 1 || ny >= R+1 || nx >= C+1 || visit[ny][nx] == -1) continue;
						visit[ny][nx] = -1;
						q2.add(new Point(ny, nx));
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
		map = new char[R+2][C+2];
		visit = new int[R+2][C+2];
		for(int i = 0; i<R+2; i++) {
			String str = "";
			if(1 <= i && i < R+1)
				str = br.readLine();
			for(int j = 0; j<C+2; j++) {
				if(i == 0 || j == 0 || i == R+1 || j == C+1) {
					map[i][j] = '.';
					continue;
				}
				map[i][j] = str.charAt(j - 1);
				if(map[i][j] == 'J') {
					jihoon = new Point(i, j);
					visit[i][j] = 1;
				}else if(map[i][j] == 'F') {
					fire.add(new Point(i, j));
					visit[i][j] = -1;
				}else if(map[i][j] == '#')
					visit[i][j] = -1;
			}
		}
		bfs();
		System.out.println(ans);
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
