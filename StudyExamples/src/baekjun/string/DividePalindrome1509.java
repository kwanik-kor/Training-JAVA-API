package baekjun.string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class DividePalindrome1509 {
	static boolean pal[][] = new boolean[2501][2501];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = br.readLine();
		int n = str.length();
		str = " " + str;
		for(int i = 1; i<=n; i++)
			pal[i][i] = true;
		for(int i = 1; i<n; i++)
			if(str.charAt(i) == str.charAt(i + 1))
				pal[i][i+1] = pal[i+1][i] = true;
		for(int i = 2; i<n; i++) 
			for(int j = 1; j<=n-i; j++) 
				if(str.charAt(j) == str.charAt(i + j) && pal[j+1][j+i-1])
					pal[j][j+i] = pal[j+i][j] = true;
		
		int[] dp = new int[n + 1];
		for(int i = 1; i<=n; i++) {
			for(int j = 1; j<=i; j++) {
				if(pal[i][j] && (dp[i] == 0 || dp[i] > dp[j-1] + 1))
					dp[i] = dp[j-1] + 1;
			}
		}
		bw.write(dp[n] + "");
		bw.flush();
		bw.close();
		br.close();
	}

}
