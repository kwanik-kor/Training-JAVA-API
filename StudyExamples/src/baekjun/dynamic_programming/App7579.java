package baekjun.dynamic_programming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class App7579 {
	static int N, M;
	static long dp[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		App apps[] = new App[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++)
			apps[i] = new App(Long.parseLong(st.nextToken()), 0);
		st = new StringTokenizer(br.readLine());
		int total = 0;
		for(int i = 0; i<N; i++) {
			apps[i].c = Integer.parseInt(st.nextToken());
			total += apps[i].c;
		}
		dp = new long[total + 1];
		for(int i = 0; i<N; i++) {
			for(int j = total; j>=apps[i].c; j--){
				dp[j] = Math.max(dp[j], dp[j-apps[i].c] + apps[i].m);
			}
		}
		for(int i = 0; i<=total; i++) {
			if(dp[i] >= M){
				bw.write(i + "");
				break;
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	static class App{
		long m;
		int c;
		public App(long m, int c) {
			this.m = m;
			this.c = c;
		}
	}
}
