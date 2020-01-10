package baekjun.backtracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class NAndM15652 {
	static int N, M;
	static int result[];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		result = new int[M];
		backTracking(0);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	static void backTracking(int cnt) {
		if(cnt == M) {
			for(int i = 0; i<M; i++)
				sb.append(result[i] + " ");
			sb.append("\n");
			return;
		}
		for(int i = 1; i<=N; i++) {
			result[cnt] = i;
			if(cnt == 0)
				backTracking(cnt + 1);
			if(cnt > 0 && result[cnt] >= result[cnt-1])
				backTracking(cnt + 1);
		}
	}
}
