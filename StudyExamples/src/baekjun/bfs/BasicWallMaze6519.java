package baekjun.bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BasicWallMaze6519 {
	//ºÏ µ¿ ³² ¼­
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	static int[] bit = {1, 2, 4, 8};
	static String[] direction = {"N", "E", "S", "W"};
	static int[][] map;
	static String[][] visit;
	static Point start, end;
	static StringTokenizer st;
	
	static void bfs() {
		Queue<Point> q = new LinkedList<Point>();
		q.add(start);
		visit[start.y][start.x] = "S";
		while(!q.isEmpty()) {
			Point now = q.poll();
			if(now.y == end.y && now.x == end.x)
				break;
			for(int i = 0; i<4; i++) {
				int ny = now.y + dy[i];
				int nx = now.x + dx[i];
				if(ny < 0 || nx < 0 || ny >= 6 || nx >= 6 || visit[ny][nx] != null) continue;
				if((map[now.y][now.x] | bit[i]) != map[now.y][now.x]) {
					visit[ny][nx] = visit[now.y][now.x] + direction[i];
					q.add(new Point(ny, nx));
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = "";
		while(!(str = br.readLine()).equals("0 0")) {
			st = new StringTokenizer(str);
			int start_x = Integer.parseInt(st.nextToken()) - 1;
			int start_y = Integer.parseInt(st.nextToken()) - 1;
			start = new Point(start_y, start_x);
			st = new StringTokenizer(br.readLine());
			int end_x = Integer.parseInt(st.nextToken()) - 1;
			int end_y = Integer.parseInt(st.nextToken()) - 1;
			end = new Point(end_y, end_x);
			visit = new String[6][6];
			map = new int[6][6];
			for(int i = 0; i<3; i++) {
				st = new StringTokenizer(br.readLine());
				int x1 = Integer.parseInt(st.nextToken());
				int y1 = Integer.parseInt(st.nextToken());
				int x2 = Integer.parseInt(st.nextToken());
				int y2 = Integer.parseInt(st.nextToken());
				if(x1 == x2) {
					for(int y = Math.min(y1, y2); y < Math.max(y1, y2); y++) {
						if(x1 < 6)
							map[y][x1] += 8;
						if(x1 - 1 >= 0)
							map[y][x1-1] += 2;
					}
				}else {
					for(int x = Math.min(x1, x2); x < Math.max(x1, x2); x++) {
						if(y1 < 6)
							map[y1][x] += 1;
						if(y1 - 1 >= 0)
							map[y1-1][x] += 4;
					}
				}
			}
			bfs();
			bw.write(visit[end.y][end.x].substring(1) + "\n");
		}
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
