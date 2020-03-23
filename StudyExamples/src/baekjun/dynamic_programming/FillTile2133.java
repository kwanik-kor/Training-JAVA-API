package baekjun.dynamic_programming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FillTile2133 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[31];
		int ret = 0;
		if(N % 2 == 0) {
			dp[0] = 1;
			for(int i = 2; i<=N; i += 2)
				for(int j = 2; j<=i; j += 2) 
					dp[i] += ((j == 2)? 3 : 2) * dp[i - j];
			ret = dp[N];
		}
		bw.write(ret + "");
		bw.flush();
		bw.close();
		br.close();
	}

}
