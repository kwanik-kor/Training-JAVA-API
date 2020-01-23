package baekjun.dynamic_programming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Tiling11727 {
	static int N, dp[];
	
	static void dp() {
		if(N>=1) dp[1] = 1;
		if(N>=2) dp[2] = 3;
		for(int i = 3; i<N+1; i++) {
			dp[i] = (dp[i-1] + dp[i-2]*2)%10007;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		dp = new int[N+1];
		dp();
		bw.write(dp[N] + "");
		bw.flush();
		bw.close();
		br.close();
	}

}
