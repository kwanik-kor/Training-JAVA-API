package baekjun.dynamic_programming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MakeOne1463 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int dp[] = new int[N+1];
		dp[1] = dp[0] = 0;
		for(int i = 2; i<=N; i++) {
			dp[i] = dp[i-1] + 1;
			if(i % 2 == 0)
				dp[i] = Math.min(dp[i], dp[i/2] + 1);
			if(i % 3 == 0)
				dp[i] = Math.min(dp[i], dp[i/3] + 1);
		}
		bw.write(String.valueOf(dp[N]));
		bw.flush();
		bw.close();
		br.close();
	}

}
