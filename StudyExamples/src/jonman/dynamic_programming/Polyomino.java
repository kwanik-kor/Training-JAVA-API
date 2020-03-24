package jonman.dynamic_programming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Polyomino {
	static int dp[][];
	static int MOD = 10000000;
	
	static int poly(int n, int first) {
		if(first == n) return 1;
		if(dp[n][first] != -1) return dp[n][first];
		dp[n][first] = 0;
		for(int second = 1; second <= n-first; second++) {
			int add = second + first - 1;
			add *= poly(n - first, second);
			add %= MOD;
			dp[n][first] += add;
			dp[n][first] %= MOD;
		}
		return dp[n][first];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		dp = new int[101][101];
		for(int i = 0; i<=100; i++)
			Arrays.fill(dp[i], -1);
		int testCase = Integer.parseInt(br.readLine());
		for(int t = 0; t<testCase; t++) {
			int n = Integer.parseInt(br.readLine());
			int ret = 0;
			for(int i = 1; i<=n; i++) {
				ret += poly(n, i);
				ret %= MOD;
			}
			bw.write(ret + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
