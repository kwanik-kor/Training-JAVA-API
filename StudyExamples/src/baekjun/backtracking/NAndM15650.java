package baekjun.backtracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class NAndM15650 {
	static int N, M;
	static boolean[] visit;
	static int[] result;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visit = new boolean[N+1];
		result = new int[N];
		backTracking(0);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	private static void backTracking(int cnt) {
		if(cnt == M) {
			for(int i = 0; i<M; i++) {
				sb.append(result[i] + " ");
			}
			sb.append("\n");
			return;
		}
		for(int i = 1; i<=N; i++) {
			if(visit[i]) continue;
			result[cnt] = i;
			visit[i] = true;
			if(cnt == 0)
				backTracking(cnt+1);
			if(cnt > 0 && result[cnt] > result[cnt-1])
				backTracking(cnt+1);
			visit[i] = false;
		}
	}
}
