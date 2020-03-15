package baekjun.bruteforce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Tetromino14500 {
	static int N, M, max = 0;
	static int map[][];
	static boolean visit[][];
	static int dx[] = {-1, 0, 1, 0};
	static int dy[] = {0, 1, 0, -1};
	
	static void fuck(int y, int x, int sum) {
		int fuckSum = 0;
		//で
		if(x-1 >= 0 && x+1 < M && y-1 >= 0 && y < N) 
			fuckSum = Math.max(fuckSum, sum + map[y][x-1] + map[y][x+1] + map[y-1][x]);
		//た
		if(y-1 >= 0 && y+1 < N && x >= 0 && x+1 < M)
			fuckSum = Math.max(fuckSum, sum + map[y-1][x] + map[y+1][x] + map[y][x+1]);
		//ぬ
		if(y+1 < N && y >= 0 && x-1 >= 0 && x+1 < M)
			fuckSum = Math.max(fuckSum, sum + map[y][x-1] + map[y][x+1] + map[y+1][x]);
		//っ
		if(y+1 < N && y-1 >= 0 && x-1 >= 0 && x < M)
			fuckSum = Math.max(fuckSum, sum + map[y-1][x] + map[y+1][x] + map[y][x-1]);
		max = Math.max(fuckSum, max);
	}
	
	static void makeTetromino(int y, int x, int cnt, int sum) {
		if(cnt == 4) {
			max = Math.max(max, sum);
			return;
		}
		for(int i = 0; i<4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if(ny >= 0 && ny < N && nx >= 0 && nx < M && !visit[ny][nx]) {
				visit[ny][nx] = true;
				makeTetromino(ny, nx, cnt + 1, sum + map[ny][nx]);
				visit[ny][nx] = false;
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
		visit = new boolean[N][M];
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				visit[i][j] = true;
				makeTetromino(i, j, 1, map[i][j]);
				fuck(i, j, map[i][j]);
				visit[i][j] = false;
			}
		}
		bw.write(max + "");
		bw.flush();
		bw.close();
		br.close();
	}

}
