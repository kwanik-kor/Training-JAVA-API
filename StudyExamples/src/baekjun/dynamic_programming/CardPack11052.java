package baekjun.dynamic_programming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class CardPack11052 {
	static int N, arr[], dp[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		dp = new int[N+1];
		arr = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i<=N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		for(int i = 1; i<=N; i++) {
			for(int j = 1; j<=i; j++) {
				dp[i] = Math.max(dp[i], dp[i-j] + arr[j]);
			}
		}
		
		bw.write(dp[N]+"");
		bw.flush();
		bw.close();
		br.close();
	}

}
