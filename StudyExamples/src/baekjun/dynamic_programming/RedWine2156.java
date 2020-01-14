package baekjun.dynamic_programming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class RedWine2156 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int glass[] = new int[n];
		int dp[] = new int[n];
		for(int i = 0; i<n; i++) {
			glass[i] = Integer.parseInt(br.readLine());
		}
		if(n>=1) dp[0] = glass[0];
		if(n>=2) dp[1] = glass[0] + glass[1];
		if(n>=3) dp[2] = Math.max(dp[1], Math.max(glass[2] + dp[0], glass[2] + glass[1]));
		for(int i = 3; i<n; i++) {
			dp[i] = Math.max(dp[i-1], Math.max(glass[i] + dp[i-2], glass[i] + glass[i-1] + dp[i-3]));
		}
		bw.write(String.valueOf(dp[n-1]));
		bw.flush();
		bw.close();
		br.close();
	}

}
