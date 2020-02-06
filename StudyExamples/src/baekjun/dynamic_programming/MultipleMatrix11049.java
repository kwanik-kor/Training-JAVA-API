package baekjun.dynamic_programming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class MultipleMatrix11049 {
	static int N, MAX = Integer.MAX_VALUE;
	static ArrayList<Matrix> marr = new ArrayList<>();
	static int[][] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		dp = new int[N+1][N+1];
		for(int i = 1; i<=N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			marr.add(new Matrix(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			for(int j = 1; j<=N; j++)
				dp[i][j] = MAX;
		}
		bw.write(dp(1, N)+"");
		bw.flush();
		bw.close();
	}
	
	static int dp(int start, int end) {
		Matrix ms = marr.get(start-1);
		Matrix me = marr.get(end-1);
		if(start >= end) return 0;
		if(start + 1 == end) return ms.x * ms.y * me.y;
		if(dp[start][end] < MAX)
			return dp[start][end];
		for(int i = start; i<end; i++) {
			int temp = dp(start, i) + dp(start+1, end) + (ms.x*ms.y*me.y);
			dp[start][end] = Math.min(dp[start][end], temp);
		}
		
		return dp[start][end];
	}
	
	static class Matrix{
		int x;
		int y;
		Matrix(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
}
