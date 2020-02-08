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
	//곱하는 값을 변경해줘야함
	static int dp(int start, int end) {
		if(start >= end) return 0;
		if(start + 1 == end) {
			Matrix ms = marr.get(start-1);
			Matrix me = marr.get(end-1);
			return ms.x * ms.y * me.y;
		}
		if(dp[start][end] < MAX)
			return dp[start][end];
		for(int i = start; i<end; i++) {
			Matrix ms = marr.get(start-1);
			Matrix mm = marr.get(i);
			Matrix me = marr.get(end-1);
			int temp = dp(start, i) + dp(i+1, end) + (ms.x*mm.x*me.y);
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
