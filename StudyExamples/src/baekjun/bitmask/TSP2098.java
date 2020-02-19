package baekjun.bitmask;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class TSP2098 {
	static int N;
	static int dp[][], W[][];
	static final int INF = 98765421;
	
	static int tsp(int now, int visit) {
		if(visit == (1<<N) - 1) {
			if(W[now][0] == 0) return INF;
			return W[now][0];
		}
		
		if(dp[now][visit] != 0) 
			return dp[now][visit];
		dp[now][visit] = INF;
		
		for(int i = 0; i<N; i++) {
			int next = 1 << i;
			if(W[now][i] == 0 || (visit & next) > 0)
				continue;
			dp[now][visit] = Math.min(dp[now][visit], tsp(i, visit | next) + W[now][i]);
		}
		return dp[now][visit];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		W = new int[N][N];
		dp = new int[N][1 << 16];
		for(int i = 0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j<N; j++)
				W[i][j] = Integer.parseInt(st.nextToken());
		}
		bw.write(tsp(0,1) + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

}
