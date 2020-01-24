package baekjun.dynamic_programming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Bridge1010 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int t = 0; t<T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			long map[][] = new long[N+1][M+1];
			for(int i = 0; i<=M; i++) map[1][i] = i;
			for(int i = 2; i<=N; i++) {
				for(int j = i; j<=M; j++) {
					for(int k = j; k>=i; k--) {
						map[i][j] += map[i-1][k-1];
					}
				}
			}
			bw.write(map[N][M] + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
