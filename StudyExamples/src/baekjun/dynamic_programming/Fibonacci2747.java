package baekjun.dynamic_programming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Fibonacci2747 {
	static int N, dp[];
	
	static void fibo() {
		dp = new int[N+1];
		if(N >= 1) dp[1] = 1;
		if(N >= 2) dp[2] = 1;
		for(int i = 3; i<=N; i++)
			dp[i] = dp[i-1] + dp[i-2];
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		fibo();
		bw.write(dp[N] + "");
		bw.flush();
		bw.close();
		br.close();
	}

}
