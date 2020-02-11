package baekjun.dynamic_programming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Palindrom10942 {
	static int N, arr[], dp[][];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1];
		dp = new int[N+1][N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i<=N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			dp[i][i] = 1;
		}
		for(int i = 1; i<N; i++) {
			if(arr[i] == arr[i+1])
				dp[i][i+1] = dp[i+1][i] = 1;
		}
		for(int i = 2; i<N; i++) {
			for(int j = 1; j + i<=N; j++) {
				if(arr[j] == arr[j+i] && dp[j+1][j+i-1] == 1)
					dp[j][j+i] = dp[j+i][j] = 1;
			}
		}
		int test = Integer.parseInt(br.readLine());
		for(int i = 0; i<test; i++) {
			st = new StringTokenizer(br.readLine());
			bw.write(dp[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
