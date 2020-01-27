package baekjun.bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class JoodysCarrot16433 {
	static int N, R, C;
	static char map[][];
	static int x[] = {-1, 1, 1, -1};
	static int y[] = {1, 1, -1, -1};
	
	static void BFS(int a, int b) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(a, b));
		while(!q.isEmpty()) {
			Point p = q.poll();
			for(int i = 0; i<4; i++) {
				int dx = p.x + x[i];
				int dy = p.y + y[i];
				if(dx > -1 && dx < N && dy > -1 && dy < N && map[dx][dy] == '.') {
					q.add(new Point(dx, dy));
					map[dx][dy] = 'v';
				}
			}
			
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[N][N];
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++)
				map[i][j] = '.';
		}
		BFS(R-1, C-1);
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++)
				bw.write(map[i][j]);
			bw.write("\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	static class Point{
		int x;
		int y;
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
}
