package baekjun.bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class KnightMoves6601 {
	static int[] dy = {-2, -2, -1, 1, 2, 2, -1, 1};
	static int[] dx = {-1, 1, 2, 2, -1, 1, -2, -2};
	static int[][] map = new int[8][8];
	static Point start, end;
	
	static void bfs() {
		Queue<Point> q = new LinkedList<Point>();
		q.add(start);
		map[start.y][start.x] = 1;
		while(!q.isEmpty()) {
			Point now = q.poll();
			if(now.y == end.y && now.x == end.x)
				break;
			for(int dir = 0; dir < 8; dir++) {
				int ny = now.y + dy[dir];
				int nx = now.x + dx[dir];
				if(ny < 0 || ny >= 8 || nx < 0 || nx >= 8 || map[ny][nx] != 0) continue;
				map[ny][nx] = map[now.y][now.x] + 1;
				q.add(new Point(ny, nx));
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = "";
		while((str = br.readLine()) != null && str.length() > 0) {
			StringTokenizer st = new StringTokenizer(str);
			String s1 = st.nextToken();
			start = new Point(s1.charAt(0) - 'a', s1.charAt(1) - '1');
			String s2 = st.nextToken();
			end = new Point(s2.charAt(0) - 'a', s2.charAt(1) - '1');
			for(int i = 0; i<8; i++)
				Arrays.fill(map[i], 0);
			bfs();
			bw.write(String.format("To get from %s to %s takes %d knight moves.\n", s1, s2, map[end.y][end.x] - 1));
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
