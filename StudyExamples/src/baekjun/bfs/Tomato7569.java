package baekjun.bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Tomato7569 {
	static int M, N, H, map[][][];
	static int x[] = {0, 0, 0, 0, 1, -1};
	static int y[] = {-1, 0, 1, 0, 0, 0};
	static int z[] = {0, 1, 0, -1, 0, 0};
	
	static void BFS() {
		Queue<Point> q = new LinkedList<>();
		for(int i = 0; i<H; i++) {
			for(int j = 0; j<N; j++) {
				for(int k = 0; k<M; k++) {
					if(map[i][j][k] == 1) q.add(new Point(i, j, k));
				}
			}
		}
		while(!q.isEmpty()) {
			Point p = q.poll();
			for(int i = 0; i<6; i++) {
				int dx = p.x + x[i];
				int dy = p.y + y[i];
				int dz = p.z + z[i];
				if(dx > -1 && dx < H && dy > -1 && dy < N && dz > -1 && dz < M && map[dx][dy][dz] == 0) {
					q.add(new Point(dx, dy, dz));
					map[dx][dy][dz] = map[p.x][p.y][p.z] + 1;
				}
			}
		}
	}
	
	static int checkResult() {
		int result = 0;
		boolean chk = false;
		for(int i = 0; i<H; i++) {
			if(chk) break;
			for(int j = 0; j<N; j++) {
				if(chk) break;
				for(int k = 0; k<M; k++) {
					if(map[i][j][k] == 0) {
						chk = true;
						break;
					}
					result = Math.max(result, map[i][j][k]);
				}
			}
		}
		return (chk)? -1 : result-1;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H][N][M];
		int zeroCount = 0;
		for(int i = 0; i<H; i++) {
			for(int j = 0; j<N; j++) {
				st = new StringTokenizer(br.readLine());
				for(int k = 0; k<M; k++) {
					map[i][j][k] = Integer.parseInt(st.nextToken());
					if(map[i][j][k] == 0) zeroCount++;
				}
			}
		}
		if(zeroCount != 0) {
			BFS();
			bw.write(checkResult()+"");
		}else
			bw.write(0 + "");
		bw.flush();
		bw.close();
		br.close();
	}
	
	static class Point{
		int x;
		int y;
		int z;
		Point(int x, int y, int z){
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}
}
