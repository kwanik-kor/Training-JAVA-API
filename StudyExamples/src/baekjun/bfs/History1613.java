package baekjun.bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class History1613 {
	static int N, K;
	static ArrayList<Integer> adj[];
	static boolean visit[];
	static int dp[][];
	static final int MAX = 402;
	
	static void floyd() {
		for(int k = 1; k<=N; k++) {
			for(int i = 1; i<=N; i++) {
				for(int j = 1; j<=N; j++) {
					if(dp[i][j] > dp[i][k] + dp[k][j])
						dp[i][j] = dp[i][k] + dp[k][j];
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		adj = new ArrayList[N+1];
		visit = new boolean[N+1];
		dp = new int[N+1][N+1];
		for(int i = 1; i<=N; i++)
			adj[i] = new ArrayList<Integer>();
		while(K-- > 0) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			adj[u].add(v);
		}
		for(int i = 1; i<=N; i++)
			Arrays.fill(dp[i], MAX);
		for(int i = 1; i<=N; i++) 
			for(Integer next : adj[i]) 
				dp[i][next] = 1;
		floyd();
		
		int s = Integer.parseInt(br.readLine());
		while(s-- > 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(dp[a][b] < MAX)
				bw.write("-1\n");
			else {
				if(dp[b][a] < MAX)
					bw.write("1\n");
				else bw.write("0\n");
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
