package baekjun.dfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SelectNum2668 {
	static int N;
	static int maxLen = 0;
	static int[] arr;
	static boolean[] visit, cycle;
	
	static boolean dfs(int start, int node) {
		if(visit[node])
			return false;
		visit[node] = true;
		if(start == node || dfs(start, arr[node])) {
			maxLen++;
			cycle[node] = true;
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1];
		visit = new boolean[N+1];
		cycle = new boolean[N+1];
		for(int i = 1; i<=N; i++)
			arr[i] = Integer.parseInt(br.readLine());
		for(int i = 1; i<=N; i++) {
			for(int j = 1; j<=N; j++)
				visit[j] = cycle[j];
			dfs(i, arr[i]);
		}
		bw.write(maxLen + "\n");
		for(int i = 1; i<=N; i++) {
			if(cycle[i]) bw.write(i + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
