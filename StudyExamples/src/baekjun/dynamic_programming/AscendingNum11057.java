package baekjun.dynamic_programming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class AscendingNum11057 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int dp[][] = new int[N+1][10];
		dp[1][0] = 1;
		for(int i = 1; i<10; i++)
			dp[1][i] = dp[1][i-1] + 1;
		for(int i = 2; i<=N; i++) {
			dp[i][0] = 1;
			for(int j = 1; j<10; j++) {
				dp[i][j] = (dp[i-1][j] + dp[i][j-1])%10007;
			}
		}
		bw.write(dp[N][9] + "");
		bw.flush();
		bw.close();
		br.close();
	}

}
