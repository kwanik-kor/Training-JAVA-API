package baekjun.dynamic_programming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class MergeFile11066 {
	static int MAX = Integer.MAX_VALUE;
	static int[] arr, sum;
	static int[][] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCase = Integer.parseInt(br.readLine());
		for(int t = 0; t<testCase; t++) {
			int K = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr = new int[K+1];
			sum = new int[K+1];
			dp = new int[K+1][K+1];
			
			for(int i = 1; i<=K; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				sum[i] = sum[i-1] + arr[i];
				for(int j = 1; j<=K; j++)
					dp[i][j] = MAX;
			}
			
			bw.write(solve(1, K) + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	static int solve(int start, int end) {
		if(start >= end)
			return 0;
		
		if(start + 1 == end)
			return arr[start] + arr[end];
		
		if(dp[start][end] < MAX)
			return dp[start][end];
		
		for(int i = start; i<end; i++) {
			int temp = solve(start, i) + solve(i+1, end) + sum[end] - sum[start - 1];
			dp[start][end] = Math.min(dp[start][end], temp);
		}
			
		return dp[start][end];
	}

}
