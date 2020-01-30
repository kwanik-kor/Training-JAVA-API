package baekjun.bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class ColorBlindness10026 {
	static int N, ans1 = 0, ans2 = 0;
	static int x[] = {-1,0,1,0};
	static int y[] = {0,1,0,-1};
	static char map[][];
	static boolean visit[][];
	
	static void BFS(int a, int b) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(a, b));
		visit[a][b] = true;
		char c = map[a][b];
		while(!q.isEmpty()) {
			Point p = q.poll();
			for(int i = 0; i<4; i++) {
				int dx = p.x + x[i];
				int dy = p.y + y[i];
				if(dx > -1 && dx < N && dy > -1 && dy < N && !visit[dx][dy] && map[dx][dy] == c) {
					q.add(new Point(dx, dy));
					visit[dx][dy] = true;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		visit = new boolean[N][N];
		for(int i = 0; i<N; i++) {
			char arr[] = br.readLine().toCharArray();
			for(int j = 0; j<N; j++)
				map[i][j] = arr[j];
		}
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				if(!visit[i][j]){
					BFS(i, j);
					ans1++;
				}
			}
		}
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				visit[i][j] = false;
				if(map[i][j] == 'G')
					map[i][j] = 'R';
			}
		}
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				if(!visit[i][j]){
					BFS(i, j);
					ans2++;
				}
			}
		}
		bw.write(ans1 + "\n" + ans2);
		bw.flush();
		br.close();
		bw.close();
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
