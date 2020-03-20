package jonman.dynamic_programming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Wildcard {
	static int[][] cache = new int[101][101];
	static String pattern, filename;
	
	static int solve(int w, int s) {
		if(cache[w][s] != -1) return cache[w][s];
		
		if(w < pattern.length() && s < filename.length() && (pattern.charAt(w) == '?' || pattern.charAt(w) == filename.charAt(s))) {
			return cache[w][s] = solve(w + 1, s + 1);
		}
		if(w == pattern.length())
			return cache[w][s] = (s == filename.length()? 1 : 0);
		if(pattern.charAt(w) == '*') {
			if(solve(w + 1, s) == 1 || (s < filename.length() && solve(w, s + 1) == 1))
				return cache[w][s] = 1;
		}
		return cache[w][s] = 0;
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCase = Integer.parseInt(br.readLine());
		for(int t = 0; t<testCase; t++) {
			pattern = br.readLine();
			int n = Integer.parseInt(br.readLine());
			for(int i = 0; i<n; i++) {
				for(int j = 0; j<101; j++)
					Arrays.fill(cache[j], -1);
				filename = br.readLine();
				if(solve(0, 0) == 1)
					bw.write(filename + "\n");
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
