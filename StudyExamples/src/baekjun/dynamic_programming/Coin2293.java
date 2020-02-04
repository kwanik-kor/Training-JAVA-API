package baekjun.dynamic_programming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Coin2293 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int coin[] = new int[n];
		int dp[] = new int[k+1];
		for(int i = 0; i<n; i++)
			coin[i] = Integer.parseInt(br.readLine());
		dp[0] = 1;
		for(int i = 0; i<n; i++) {
			for(int j = 1; j<=k; j++) {
				if(j-coin[i] >= 0)
					dp[j] += dp[j - coin[i]];
			}
		}
		bw.write(dp[k] + "");
		bw.flush();
		bw.close();
		br.close();
	}

}
