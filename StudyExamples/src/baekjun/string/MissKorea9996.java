package baekjun.string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class MissKorea9996 {
	static String pattern, file;
	static int[][] dp = new int[101][101];

	static int isPossible(int w, int s) {
		if(dp[w][s] != -1) return dp[w][s];
		
		if(w < pattern.length() && s < file.length() && pattern.charAt(w) == file.charAt(s))
			return dp[w][s] = isPossible(w + 1, s + 1);
		if(w == pattern.length())
			return dp[w][s] = ((s == file.length())? 1: 0);
		if(pattern.charAt(w) == '*') {
			if(isPossible(w + 1, s) == 1 || (s < file.length() && isPossible(w, s + 1) == 1))
				return dp[w][s] = 1;
		}
		return dp[w][s] = 0;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		pattern = br.readLine();
		while(N-- > 0) {
			for(int j = 0; j<101; j++)
				Arrays.fill(dp[j], -1);
			file = br.readLine();
			if(isPossible(0, 0) == 1) bw.write("DA\n");
			else bw.write("NE\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
