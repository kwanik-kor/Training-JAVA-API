package baekjun.bruteforce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Watch15683 {
	static int N, M;
	static int min = 987654321;
	static ArrayList<Point> cctv = new ArrayList<Point>();
	static int dy[] = {-1, 0, 1, 0};
	static int dx[] = {0, 1, 0, -1};
	
	static int countBlindSpot(int[][] map) {
		int cnt = 0;
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				if(map[i][j] == 0) cnt++;
			}
		}
		return cnt;
	}
	
	static void detect(int[][] map, Point p, int dir) {
		int ny = p.y;
		int nx = p.x;
		while(true) {
			ny += dy[dir];
			nx += dx[dir];
			if(ny >= 0 && ny < N && nx >= 0 && nx < M && map[ny][nx] != 6) 
				map[ny][nx] = 7;
			else
				break;
		}
	}
	
	static void solve(int[][] map, int idx) {
		int[][] new_map = new int[N][M];
		if(idx == cctv.size()) {
			min = Math.min(min, countBlindSpot(map));
			return;
		}
		
		Point p = cctv.get(idx);
		switch(p.type) {
		case 1:
			for(int i = 0; i<4; i++) {
				for(int k = 0; k<N; k++) {
					new_map[k] = Arrays.copyOf(map[k], M);
				}
				detect(new_map, p, i);
				solve(new_map, idx + 1);
			}
			break;
		case 2: 
			for(int i = 0; i<2; i++) {
				for(int k = 0; k<N; k++) {
					new_map[k] = Arrays.copyOf(map[k], M);
				}
				detect(new_map, p, i);
				detect(new_map, p, i + 2);
				solve(new_map, idx + 1);
			}
			break;
		case 3: 
			for(int i = 0; i<4; i++) {
				for(int k = 0; k<N; k++) {
					new_map[k] = Arrays.copyOf(map[k], M);
				}
				detect(new_map, p, i);
				detect(new_map, p, (i+1)%4);
				solve(new_map, idx + 1);
			}
			break;
		case 4: 
			for(int i = 0; i<4; i++) {
				for(int k = 0; k<N; k++) {
					new_map[k] = Arrays.copyOf(map[k], M);
				}
				for(int j = 0; j<4; j++) {
					if(i != j)
						detect(new_map, p, j);
				}
				solve(new_map, idx + 1);
			}
			break;
		case 5:
			for(int k = 0; k<N; k++) {
				new_map[k] = Arrays.copyOf(map[k], M);
			}
			for(int i = 0; i<4; i++)
				detect(new_map, p, i);
			solve(new_map, idx + 1);
			break;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int map[][] = new int[N][M];
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] != 0 && map[i][j] != 6)
					cctv.add(new Point(map[i][j], i, j));
			}
		}
		solve(map, 0);
		bw.write(min + "");
		bw.flush();
		bw.close();
		br.close();
	}
	
	static class Point{
		int type;
		int y;
		int x;
		public Point(int type, int y, int x) {
			this.type = type;
			this.y = y;
			this.x = x;
		}
	}
}
