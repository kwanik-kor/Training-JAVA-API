package baekjun.dynamic_programming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Sticker9465 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t<T; t++) {
			int N = Integer.parseInt(br.readLine());
			int map[][] = new int[2][N+1];
			int dp[][] = new int[2][N+1];
			StringTokenizer st;
			for(int i = 0; i<2; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 1; j<=N; j++)
					map[i][j] = Integer.parseInt(st.nextToken());
			}
			dp[0][1] = map[0][1];
			dp[1][1] = map[1][1];
			for(int i = 2; i<=N; i++) {
				dp[0][i] = Math.max(dp[1][i-1] + map[0][i], dp[1][i-2] + map[0][i]);
				dp[1][i] = Math.max(dp[0][i-1] + map[1][i], dp[0][i-2] + map[1][i]);
			}
			bw.write(Math.max(dp[0][N], dp[1][N]) + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
		
	}

}
