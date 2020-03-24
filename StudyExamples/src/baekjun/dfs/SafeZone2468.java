package baekjun.dfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SafeZone2468 {
	static int N;
	static int height;
	static int[][] map;
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	static boolean[][] visit;
	static ArrayList<Integer> list;
	static StringTokenizer st;
	
	static void dfs(int y, int x, int k) {
		if(list.size() == k) list.add(1);
		
		visit[y][x] = true;
		for(int dir = 0; dir<4; dir++) {
			int ny = y + dy[dir];
			int nx = x + dx[dir];
			if(ny < 0 || nx < 0 || ny >= N || nx >= N || visit[ny][nx]) continue;
			else if(map[ny][nx] > height)
				dfs(ny, nx, k);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		int maxHeight = 0;
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<N; j++){
				map[i][j] = Integer.parseInt(st.nextToken());
				maxHeight = Math.max(maxHeight, map[i][j]);
			}
		}
		
		int ans = 1;
		for(int h = 1; h<maxHeight; h++) {
			int cnt = 0;
			height = h;
			visit = new boolean[N][N];
			list = new ArrayList<>();
			list.add(0);
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<N; j++) {
					if(!visit[i][j] && map[i][j] > height)
						dfs(i, j, ++cnt);
				}
			}
			ans = Math.max(ans, list.size() - 1);
		}
		bw.write(ans + "");
		bw.flush();
		bw.close();
		br.close();
	}

}
