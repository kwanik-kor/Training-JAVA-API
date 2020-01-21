package baekjun.dfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class FindPath11403 {
	static int map[][], N, result[][];
	
	static void dfs(int x, int visit[], boolean chk) {
		if(!chk)
			visit[x] = 1;
		for(int i = 0; i<N; i++) {
			if(map[x][i] == 1 && visit[i] == 0)
				dfs(i, visit, false);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		map = result = new int[N][N];
		StringTokenizer st;
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<N; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		for(int i = 0; i<N; i++) {
			int visit[] = new int[N];
			dfs(i, visit, true);
			result[i] = visit;
		}
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				bw.write(result[i][j] + " ");
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
