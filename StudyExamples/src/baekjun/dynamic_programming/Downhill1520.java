package baekjun.dynamic_programming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Downhill1520 {
	static int map[][], dp[][], N, M;
	static int x[] = {-1, 0, 1, 0};
	static int y[] = {0, 1, 0, -1};
	
	static int dfs(int a, int b) {
		if(a == N-1 && b == M-1) return 1;
		if(dp[a][b] == -1) {
			dp[a][b] = 0;
			for(int i = 0; i<4; i++) {
				int dx = a + x[i];
				int dy = b + y[i];
				if(dx >= 0 && dx < N && dy >= 0 && dy < M && map[a][b] > map[dx][dy]) {
					dp[a][b] += dfs(dx, dy);
				}
			}
		}
		return dp[a][b];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		dp = new int[N][M];
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1;
			}
		}
		bw.write(dfs(0, 0) + "");
		bw.flush();
		bw.close();
		br.close();
	}

}
