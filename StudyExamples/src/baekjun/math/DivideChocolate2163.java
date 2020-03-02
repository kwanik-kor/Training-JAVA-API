package baekjun.math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class DivideChocolate2163 {
	static int dp[][];
	
	static int divide(int n, int m) {
		if(n == 1 && m == 1) return 0;
		if(dp[n][m] != 0) return dp[n][m];
		
		if(n == 1)
			dp[n][m] = divide(n, m/2) + divide(n, m - m/2) + 1;
		else if(m == 1)
			dp[n][m] = divide(n/2, m) + divide(n - n/2, m) + 1;
		else 
			dp[n][m] = Math.min(divide(n, m/2) + divide(n, m - m/2), divide(n/2, m) + divide(n - n/2, m)) + 1;
		return dp[n][m];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		dp = new int[N+1][M+1];
		divide(N, M);
		bw.write(dp[N][M] + "");
		bw.flush();
		bw.close();
		br.close();
	}

}
