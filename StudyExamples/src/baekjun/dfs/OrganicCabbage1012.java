package baekjun.dfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class OrganicCabbage1012 {
	static int map[][], N, M, K, cnt;
	static int x[] = {-1, 0, 1, 0};
	static int y[] = {0, 1, 0, -1};
	
	static void dfs(int a, int b, int k) {
		map[a][b] = k;
		for(int i = 0; i<4; i++) {
			int dx = a + x[i];
			int dy = b + y[i];
			if(dx > -1 && dx < N && dy > -1 && dy < M && map[dx][dy] == 1)
				dfs(dx, dy, k);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int t = 0; t<T; t++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			cnt = 1;
			for(int i = 0; i<K; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[y][x] = 1;
			}
			
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<M; j++) {
					if(map[i][j] == 1) dfs(i,j,++cnt);
				}
			}
			bw.write(cnt - 1 + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
