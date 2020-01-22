package baekjun.bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class MazeSearch2178 {
	static int map[][];
	static boolean visit[][];
	static int x[] = {-1, 0, 1, 0};
	static int y[] = {0, 1, 0, -1};
	static int N, M;
	
	static void bfs(int a, int b) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(a, b));
		while(!q.isEmpty()) {
			Point p = q.poll();
			for(int i = 0; i<4; i++) {
				int dx = p.x + x[i];
				int dy = p.y + y[i];
				if(dx >- 1 && dx < N && dy > -1 && dy < M && map[dx][dy] == 1 && !visit[dx][dy]) {
					q.add(new Point(dx, dy));
					map[dx][dy] = map[p.x][p.y] + 1;
					visit[dx][dy] = true;
				}
			}
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visit = new boolean[N][M];
		for(int i = 0; i<N; i++) {
			String str = br.readLine();
			for(int j = 0; j<M; j++) 
				map[i][j] = str.charAt(j) - '0';
		}
		visit[0][0] = true;
		bfs(0,0);
		bw.write(map[N-1][M-1] + "");
		bw.flush();
		bw.close();
		br.close();
	}

}

class Point{
	int x;
	int y;
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}
