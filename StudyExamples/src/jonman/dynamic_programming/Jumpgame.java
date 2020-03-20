package jonman.dynamic_programming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Jumpgame {
	static int N, cnt;
	static int[][] map;
	static int dy[] = {0, 1};
	static int dx[] = {1, 0};
	
	static void solve(boolean[][] visit, int y, int x) {
		if(y == N-1 && x == N-1) {
			cnt++;
			return;
		}
		for(int i = 0; i<2; i++) {
			int ny = y + dy[i]*map[y][x];
			int nx = x + dx[i]*map[y][x];
			if(ny < N && nx < N && !visit[ny][nx]) {
				visit[ny][nx] = true;
				solve(visit, ny, nx);
				visit[ny][nx] = false;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		boolean visit[][] = new boolean[N][N];
		for(int i = 0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j<N; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		solve(visit, 0, 0);
		bw.write(cnt + "");
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
