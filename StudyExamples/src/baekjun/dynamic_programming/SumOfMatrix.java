package baekjun.dynamic_programming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SumOfMatrix {
	static int N, M;
	static int[][] map, dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N+1][M+1];
		dp = new int[N+1][M+1];
		for(int i = 1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j<=M; j++){
				map[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = dp[i][j-1] + map[i][j];
			}
		}
		int testCase = Integer.parseInt(br.readLine());
		for(int t = 0; t<testCase; t++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int sum = 0;
			for(int k = i; k<=x; k++)
				sum += dp[k][y] - dp[k][j-1];
			bw.write(sum + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
