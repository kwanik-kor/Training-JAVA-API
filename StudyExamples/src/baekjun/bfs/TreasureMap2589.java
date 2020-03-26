package baekjun.bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class TreasureMap2589 {
	static int H, W, ans = 0;
	static int[][] map, tmpMap;
	static int[] dy = {0, 1, 0, -1};
	static int[] dx = {1, 0, -1, 0};
	
	static int countLen() {
		int max = 0;
		for(int i = 0; i<H; i++)
			for(int j = 0; j<W; j++)
				max = Math.max(max, tmpMap[i][j]);
		return max;
	}
	
	static void bfs(int y, int x) {
		for(int i = 0; i<H; i++) 
			for(int j = 0 ;j<W; j++)
				tmpMap[i][j] = map[i][j];
		
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(y, x));
		tmpMap[y][x] = 1;
		while(!q.isEmpty()) {
			Point now = q.poll();
			for(int dir = 0; dir<4; dir++) {
				int ny = now.y + dy[dir];
				int nx = now.x + dx[dir];
				if(ny < 0 || nx < 0 || ny >= H || nx >= W || tmpMap[ny][nx] != 0) continue;
				tmpMap[ny][nx] = tmpMap[now.y][now.x] + 1;
				q.add(new Point(ny, nx));
			}
		}
		ans = Math.max(ans, countLen());
	}
	
	static void solve() {
		for(int i = 0; i<H; i++) {
			for(int j = 0; j<W; j++) {
				if(map[i][j] == 0)
					bfs(i, j);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		map = new int[H][W];
		tmpMap = new int[H][W];
		for(int i = 0; i<H; i++) {
			String str = br.readLine();
			for(int j = 0; j<W; j++)
				map[i][j] = (str.charAt(j) == 'L')? 0 : -1;
		}
		solve();
		bw.write(ans - 1 + "");
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
