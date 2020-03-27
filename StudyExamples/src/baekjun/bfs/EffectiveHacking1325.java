package baekjun.bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class EffectiveHacking1325 {
	static int N, M;
	static ArrayList<Integer> adj[];
	static int[] cnt;
	static boolean[] visit;
	
	static void dfs(int nd) {
		visit[nd] = true;
		for(Integer ch : adj[nd]) {
			if(visit[ch]) continue;
			cnt[ch]++;
			dfs(ch);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		adj = new ArrayList[N+1];
		cnt = new int[N+1];
		visit = new boolean[N+1];
		Arrays.fill(cnt, 1);
		for(int i = 1; i<=N; i++)
			adj[i] = new ArrayList<Integer>();
		while(M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			adj[u].add(v);
		}
		for(int i = 1; i<=N; i++) {
			Arrays.fill(visit, false);
			dfs(i);
		}
		int max = 0;
		for(int i = 1; i<=N; i++)
			max = Math.max(max, cnt[i]);
		for(int i = 1; i<=N; i++)
			if(cnt[i] == max)
				bw.write(i + " ");
		bw.flush();
		bw.close();
		br.close();
	}

}
