package baekjun.bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Postman2842 {
	static int N, house = 0;
	static int dy[] = {-1, 0, 1, 0, 1, 1, -1, -1};
	static int dx[] = {0, 1, 0, -1, 1, -1, 1, -1};
	static int alti[][];
	static char map[][];
	static boolean visit[][];
	static ArrayList<Integer> list = new ArrayList<Integer>();
	static Point P;
	
	static void bfs(int lo, int hi) {
		//시작점 예외처리 안해서 개쌉질함
		if(alti[P.y][P.x] < lo || alti[P.y][P.x] > hi) return;
		Queue<Point> q = new LinkedList<Point>();
		visit[P.y][P.x] = true;
		q.add(P);
		
		while(!q.isEmpty()) {
			Point now = q.poll();
			for(int dir = 0; dir<8; dir++) {
				int ny = now.y + dy[dir];
				int nx = now.x + dx[dir];
				if(ny < 0 || nx < 0 || ny >= N || nx >= N || visit[ny][nx] || alti[ny][nx] < lo || alti[ny][nx] > hi) continue;
				visit[ny][nx] = true;
				q.add(new Point(ny, nx));
			}
		}
	}
	
	static void dfs(int i, int j, int lo, int hi) {
		if(i < 0 || j < 0 || i >= N || j >= N || visit[i][j] || alti[i][j] < lo || alti[i][j] > hi) return;
		visit[i][j] = true;
		for(int dir = 0; dir<8; dir++)
			dfs(i + dy[dir], j + dx[dir], lo, hi);
	}
	
	static boolean possible() {
		int cnt = 0;
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				if(map[i][j] == 'K' && visit[i][j])
					cnt++;
			}
		}
		return cnt == house;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		visit = new boolean[N][N];
		alti = new int[N][N];
		for(int i = 0; i<N; i++) {
			String s = br.readLine();
			for(int j = 0; j<N; j++) {
				map[i][j] = s.charAt(j);
				if(map[i][j] == 'P')
					P = new Point(i, j);
				else if(map[i][j] == 'K')
					house++;
			}
		}
		for(int i = 0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j<N; j++) {
				alti[i][j] = Integer.parseInt(st.nextToken());
				if(!list.contains(alti[i][j]))
					list.add(alti[i][j]);
			}
		}
		Collections.sort(list);
		int ans = Integer.MAX_VALUE, left = 0, right = 0;
		while(right != list.size()) {
			while(left != list.size()) {
				int lo = list.get(left);
				int hi = list.get(right);
				for(int i = 0; i<N; i++) {
					Arrays.fill(visit[i], false);
				}
				bfs(lo, hi);
				
				if(!possible()) break;
				
				ans = Math.min(ans, hi - lo);
				left++;
			}
			right++;
		}

		bw.write(String.valueOf(ans));
		bw.flush();
		bw.close();
		br.close();
	}
	
	static class Point {
		int y;
		int x;
		public Point(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}
