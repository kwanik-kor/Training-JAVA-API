package baekjun.bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BreakWall2206 {
	static int N, M, ans;
	static int map[][], visit[][];
	static int x[] = {-1, 0, 1, 0};
	static int y[] = {0, 1, 0, -1};
	
	static void BFS() {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(0, 0, 1, 0));
		visit[0][0] = 0;
		while(!q.isEmpty()) {
			Point p = q.poll();
			if(p.x == N-1 && p.y == M-1) {
				ans = p.cnt;
				break;
			}
			for(int i = 0; i<4; i++) {
				int dx = p.x + x[i];
				int dy = p.y + y[i];
				if(dx < 0 || dx >= N || dy < 0 || dy >= M) continue;
				if(visit[dx][dy] <= p.destroy) continue;
				if(map[dx][dy] == 0) {
					visit[dx][dy] = p.destroy;
					q.add(new Point(dx, dy, p.cnt + 1, p.destroy));
				}else {
					if(p.destroy == 0) {
						visit[dx][dy] = p.destroy + 1;
						q.add(new Point(dx, dy, p.cnt + 1, p.destroy + 1));
					}
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visit = new int[N][M];
		ans = Integer.MAX_VALUE;
		for(int i = 0; i<N; i++) {
			String s = br.readLine();
			for(int j = 0; j<M; j++) {
				map[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
				visit[i][j] = Integer.MAX_VALUE;
			}
		}
		BFS();
		bw.write(((ans == Integer.MAX_VALUE)? -1 : ans) + "");
		bw.flush();
		bw.close();
		br.close();
	}
	
	static class Point{
		int x;
		int y;
		int cnt;
		int destroy;
		Point(int x, int y, int cnt, int destroy){
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.destroy = destroy;
		}
	}

}
