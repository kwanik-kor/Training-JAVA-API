package baekjun.dynamic_programming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class LCS9252 {
	static int dp[][];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String a = br.readLine();
		String b = br.readLine();
		dp = new int[a.length()][b.length()];
		for(int i = 0; i<a.length(); i++) {
			for(int j = 0; j<a.length(); j++) {
				if(a.charAt(i) == b.charAt(j))
					dp[i][j] = dp[i-1][j-1] + 1;
			}
		}
	}

}
