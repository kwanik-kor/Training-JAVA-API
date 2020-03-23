package baekjun.dynamic_programming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Coin2_2294 {
	static int n, k;
	static int[] dp, coin;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		coin = new int[n + 1];
		dp = new int[k + 1];
		for(int i = 1; i<=k; i++)
			dp[i] = 100001;
		for(int i = 1; i<=n; i++)
			coin[i] = Integer.parseInt(br.readLine());
		for(int i = 1; i<=n; i++) {
			for(int j = coin[i]; j<=k; j++) 
				dp[j] = Math.min(dp[j], dp[j-coin[i]] + 1);
		}
		bw.write((dp[k] == 100001)? "-1" : dp[k] + "");
		bw.flush();
		bw.close();
		br.close();
	}

}
