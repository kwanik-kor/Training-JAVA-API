package baekjun.dynamic_programming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class PlusCombination9095 {
	static int dp[] = new int[11];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		dp();
		for(int TestCase = 0; TestCase < T ;TestCase++) {
			bw.write(dp[Integer.parseInt(br.readLine())] + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void dp() {
		dp[0] = dp[1] = 1;
		dp[2] = 2;
		for(int i = 3; i<dp.length; i++) {
			dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
		}
	}
}
