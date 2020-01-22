package baekjun.dynamic_programming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Tiling11726 {
	static long dp[]; 
	static int n;
	
	static void dp() {
		dp = new long[n+1];
		if(n>=1) dp[1] = 1;
		if(n>=2) dp[2] = 2;
		for(int i = 3; i<=n; i++) {
			dp[i] = (dp[i-1] + dp[i-2])%10007;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(br.readLine());
		dp();
		bw.write(dp[n] + "");
		bw.flush();
		bw.close();
		br.close();
	}

}
