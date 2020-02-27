package baekjun.backtracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class GuardCastle1236 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int map[][] = new int[2][Math.max(N, M)];
		for(int i = 0; i<N; i++) {
			String s = br.readLine();
			for(int j = 0; j<M; j++) {
				if(s.charAt(j) == 'X') {
					map[0][i] = 1;
					map[1][j] = 1;
				}
			}
		}
		int x = 0;
		int y = 0;
		for(int i = 0; i<Math.max(N, M); i++) {
			if(map[0][i] == 1) x++;
			if(map[1][i] == 1) y++;
		}
		x = N-x;
		y = M-y;
		bw.write(((x<y)? y : x) + "");
		
		bw.flush();
		bw.close();
		br.close();
	}

}
