package baekjun.dynamic_programming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class LIS11055 {
	static int N;
	static int[] A, cache;
	static int maxSum;
	
	static int solve(int start) {
		if(cache[start+1] != -1) 
			return cache[start+1];
		cache[start+1] = 1;
		for(int next = start+1; next < N; next++) {
			if(start == -1 || A[start] < A[next]) {
				cache[start+1] = Math.max(cache[start+1], solve(next) + 1);
			}
		}
		return cache[start+1];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = new int[N];
		cache = new int[N+1];
		Arrays.fill(cache, -1);
		for(int i = 0; i<N; i++)
			A[i] = Integer.parseInt(st.nextToken());
		bw.write(solve(-1) -1  + "");
		bw.flush();
		bw.close();
		br.close();
	}

}
