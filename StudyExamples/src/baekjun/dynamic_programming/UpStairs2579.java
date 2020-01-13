package baekjun.dynamic_programming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class UpStairs2579 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int stair[] = new int[N+1];
		int dp[] = new int[N+1];
		for(int i = 1; i<=N; i++) {
			stair[i] = Integer.parseInt(br.readLine());
		}
		dp[1] = stair[1];
		dp[2] = stair[1] + stair[2];
		for(int i = 3; i<=N; i++) {
			dp[i] = Math.max(stair[i] + stair[i-1] + dp[i-3], stair[i] + dp[i-2]);
		}
		bw.write(String.valueOf(dp[N]));
		bw.flush();
		bw.close();
		br.close();
	}
	
}
