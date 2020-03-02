package baekjun.dynamic_programming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class NotDecreasing2688 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCase = Integer.parseInt(br.readLine());
		long dp[][] = new long[65][10];
		for(int i = 0; i<10; i++) 
			dp[1][i] = i+1;
		for(int i = 2; i<65; i++) {
			dp[i][0] = 1;
			for(int j = 1; j<10; j++) {
				dp[i][j] = dp[i-1][j] + dp[i][j-1];
			}
		}
		for(int t = 0; t<testCase; t++) {
			int n = Integer.parseInt(br.readLine());
			bw.write(dp[n][9]+ "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
