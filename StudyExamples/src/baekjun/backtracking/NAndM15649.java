package baekjun.backtracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class NAndM15649 {
	static boolean[] visit;
	static StringBuilder sb = new StringBuilder();
	static Stack<Integer> stack = new Stack<>();
	static int N, M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visit = new boolean[N+1];
		dfs(0);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	static void dfs(int cnt) {
		if(cnt == M) {
			for(int i = 0; i<M; i++)
				sb.append(stack.get(i) + " ");
			sb.append("\n");
			return;
		}
		for(int i = 1; i<=N; i++) {
			if(visit[i]) continue;
			
			stack.push(i);
			visit[i] = true;
			dfs(cnt+1);
			stack.pop();
			visit[i] = false;
		}
		
	}
}
