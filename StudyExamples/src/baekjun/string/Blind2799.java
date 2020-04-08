package baekjun.string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Blind2799 {
	static int M, N;
	static int[] cnt = new int[5];
	static char[][] map;
	
	static void solve() {
		for(int i = 0; i<M; i++) {
			for(int j = 0; j<N; j++) {
				int type = 0;
				for(int k = 0; k<4; k++) {
					if(map[4*i + k][4*j] == '*')
						type++;
					else
						break;
				}
				cnt[type]++;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new char[4*M][4*N];
		for(int i = 0; i<5*M + 1; i++) {
			String str = br.readLine();
			if(i%5 != 0) {
				for(int j = 0; j<5*N + 1; j++) {
					if(j%5 == 0) continue;
					map[i - (i/5 + 1)][j - (j/5 + 1)] = str.charAt(j); 
				}
			}
		}
		solve();
		for(int i = 0; i<5; i++)
			bw.write(cnt[i] + " ");
		bw.flush();
		bw.close();
		br.close();
	}

}
