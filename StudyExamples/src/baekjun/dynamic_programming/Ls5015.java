package baekjun.dynamic_programming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Ls5015 {
	static int cache[][] = new int[101][101];
	static String pattern, filename;
	static int plen, flen;
	
	static int solve(int w, int s) {
		if(cache[w][s] != -1) 
			return cache[w][s];
		
		if(w < plen && s < flen && pattern.charAt(w) == filename.charAt(s))
			return cache[w][s] = solve(w + 1, s + 1);
		
		if(w == plen)
			return cache[w][s] = (s == flen? 1 : 0);
		
		if(pattern.charAt(w) == '*') {
			if(solve(w + 1, s) == 1 || (s < flen && solve(w, s + 1) == 1))
				return cache[w][s] = 1;
		}
		
		return cache[w][s] = 0;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		pattern = br.readLine();
		plen = pattern.length();
		int N = Integer.parseInt(br.readLine());
		for(int n = 0; n<N; n++) {
			filename = br.readLine();
			flen = filename.length();
			for(int i = 0; i<101; i++)
				Arrays.fill(cache[i], -1);
			if(solve(0, 0) == 1)
				bw.write(filename + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
