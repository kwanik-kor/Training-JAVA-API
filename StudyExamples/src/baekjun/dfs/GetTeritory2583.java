package baekjun.dfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class GetTeritory2583 {
	static int M, N, K;
	static int cnt = 0;
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	static int[][] map;
	static ArrayList<Integer> list = new ArrayList<>();
	
	static void dfs(int y, int x, int k) {
		if(list.size() == k) list.add(1);
		else list.set(k, list.get(k) + 1);
			
		map[y][x] = k;
		for(int dir = 0; dir<4; dir++) {
			int ny = y + dy[dir];
			int nx = x + dx[dir];
			if(ny < 0 || nx < 0 || ny >= M || nx >= N || map[ny][nx] != 0)
				continue;
			dfs(ny, nx, k);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[M][N];
		while(K-- > 0) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			for(int i = M-y2; i<M-y1; i++) {
				for(int j = x1; j<x2; j++)
					map[i][j] = -1;
			}
		}
		list.add(0);
		for(int i = 0; i<M; i++) {
			for(int j = 0; j<N; j++)
				if(map[i][j] == 0)
					dfs(i, j, ++cnt);
		}
		Collections.sort(list);
		bw.write(list.size() - 1 + "\n");
		for(Integer i : list) {
			if(i != 0)
				bw.write(i + " ");
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
