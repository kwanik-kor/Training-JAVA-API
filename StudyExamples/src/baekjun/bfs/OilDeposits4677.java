package baekjun.bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class OilDeposits4677 {
	static int N, M;
	static int map[][];
	static int[] dy = {-1, 0, 1, 0, 1, 1, -1, -1};
	static int[] dx = {0, 1, 0, -1, 1, -1, 1, -1};
	
	static void bfs(int y, int x, int num) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(y, x));
		map[y][x] = num;
		while(!q.isEmpty()) {
			Point now = q.poll();
			for(int i = 0; i<8; i++) {
				int ny = now.y + dy[i];
				int nx = now.x + dx[i];
				if(ny < 0 || nx < 0 || ny >= N || nx >= M || map[ny][nx] == -1)
					continue;
				if(map[ny][nx] == 0) {
					map[ny][nx] = num;
					q.add(new Point(ny, nx));
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String s = "";
		while(!(s = br.readLine()).equals("0 0")) {
			StringTokenizer st = new StringTokenizer(s);
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			for(int i = 0; i<N; i++) {
				String str = br.readLine();
				for(int j = 0; j<M; j++) {
					if(str.charAt(j) == '*')
						map[i][j] = -1;
					else map[i][j] = 0;
				}
			}
			int num = 0;
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<M; j++) {
					if(map[i][j] == 0)
						bfs(i, j, ++num);
				}
			}
			bw.write(num + "\n");
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
