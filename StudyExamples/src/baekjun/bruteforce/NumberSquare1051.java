package baekjun.bruteforce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class NumberSquare1051 {
	static int N, M;
	static int max = 1;
	static int map[][];
	static int count[] = new int[10];
	
	static void findSquare(int y, int x) {
		//오른쪽이랑 아래쪽으로만 뻗어가자구
		int maxLength = Math.min(N-y, M-x);
		for(int len = 1; len<maxLength; len++) {
			if(map[y][x] == map[y+len][x] && map[y+len][x] == map[y][x+len] && map[y][x+len] == map[y+len][x+len])
				max = Math.max(max, (1+len)*(1+len));
		}
	}
	
	static void solve() {
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				if(count[map[i][j]] < 4) continue;
				else findSquare(i, j);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for(int i = 0; i<N; i++) {
			String tmp[] = br.readLine().split("");
			for(int j = 0; j<M; j++) {
				map[i][j] = Integer.parseInt(tmp[j]);
				count[map[i][j]]++;
			}
		}
		solve();
		bw.write(max + "");
		bw.flush();
		bw.close();
		br.close();
	}

}
