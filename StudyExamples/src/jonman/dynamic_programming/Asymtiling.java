package jonman.dynamic_programming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Asymtiling {
	static int[] dp;
	static final int MOD = 1000000007;
	
	static int tiling(int width) {
		if(width <= 1) return 1;
		if(dp[width] != -1) return dp[width];
		return dp[width] = (tiling(width - 2) + tiling(width - 1)) % MOD;
	}
	
	static int asymmetric(int width) {
		if(width % 2 == 1)
			return (tiling(width) - tiling(width/2) + MOD)%MOD;
		int ret = tiling(width);
		ret = (ret - tiling(width/2) + MOD)%MOD;
		ret = (ret - tiling(width/2 - 1) + MOD)%MOD;
		return ret;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCase = Integer.parseInt(br.readLine());
		dp = new int[101];
		Arrays.fill(dp, -1);
		for(int t = 0; t<testCase; t++) {
			bw.write(asymmetric(Integer.parseInt(br.readLine())) + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
