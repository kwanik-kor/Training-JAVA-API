package baekjun.dynamic_programming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class IntegerTriangle1932 {
	static int N;
	static int triangle[][], dp[][];
	
	static int solve(int y, int x) {
		if(y == N-1)
			return triangle[y][x];
		if(dp[y][x] != -1) 
			return dp[y][x];
		return dp[y][x] = Math.max(solve(y+1, x), solve(y+1, x+1)) + triangle[y][x];
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		dp = new int[N][N];
		triangle = new int[N][N];
		StringTokenizer st;
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			Arrays.fill(dp[i], -1);
			for(int j = 0; j<=i; j++)
				triangle[i][j] = Integer.parseInt(st.nextToken());
		}
		bw.write(solve(0, 0) + "");
		bw.flush();
		bw.close();
		br.close();
	}

}
