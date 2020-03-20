package jonman.dynamic_programming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class LIS { //Longest Increasing Subsequence
	//Multiple solutions for this Problem
	static int N;
	static int s[];
	static int cache[];
	
	static int lis2(int start) {
		if(cache[start] != -1) return cache[start];
		cache[start] = 1;
		for(int next = start+1; next<N; next++)
			if(s[start] < s[next])
				cache[start] = Math.max(cache[start], lis2(next) + 1);
		return cache[start];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		s = new int[N];
		cache = new int[N];
		for(int i = 0; i<N; i++){
			s[i] = Integer.parseInt(st.nextToken());
			cache[i] = -1;
		}
		int max = 0;
		for(int i = 0; i<N; i++)
			max = Math.max(max, lis2(i));
		bw.write(max + "");
		bw.flush();
		bw.close();
		br.close();
	}

}
