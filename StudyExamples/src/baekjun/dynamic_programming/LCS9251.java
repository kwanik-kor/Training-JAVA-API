package baekjun.dynamic_programming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class LCS9251 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String a = br.readLine();
		String b = br.readLine();
		int dp[][] = new int[a.length() + 1][b.length() + 1];
		for(int i = 1 ; i<=a.length(); i++) {
			for(int j = 1; j<=b.length(); j++) {
				if(a.charAt(i - 1) == b.charAt(j - 1))
					dp[i][j] = dp[i-1][j-1] + 1;
				else
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
			}
		}
		bw.write(String.valueOf(dp[a.length()][b.length()]));
		bw.flush();
		bw.close();
		br.close();
	}

}
