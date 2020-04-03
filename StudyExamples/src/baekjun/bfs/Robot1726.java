package baekjun.bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Robot1726 {
	static int N, M;
	static int dy[] = {0, 0, 1, -1};
	static int dx[] = {1, -1, 0, 0};
	static boolean visit[][][];
	static int map[][];
	static Point start, end;
	
	static int setDirection(int dir1, int dir2) {
		if(dir1 < 2 && dir2 >= 2 || dir1 >= 2 && dir2 < 2)
			return 1;
		else if(dir1 < 2 && dir2 < 2 || dir1 >= 2 && dir2 >= 2)
			return 2;
		return 0;
	}
	
	static int bfs() {
		Queue<Point> q = new LinkedList<Point>();
		q.add(start);
		visit[start.dir][start.y][start.x] = true;
		while(!q.isEmpty()) {
			Point now = q.poll();
			if(now.y == end.y && now.x == end.x && now.dir == end.dir)
				return now.cnt;
			for(int k = 1; k<=3; k++) {
				int ny = now.y + dy[now.dir]*k;
				int nx = now.x + dx[now.dir]*k;
				
				if(ny >= 0 && nx >= 0 && ny < M && nx < N) {
					if(map[ny][nx] == 0) {
						if(!visit[now.dir][ny][nx]) {
							visit[now.dir][ny][nx] = true;
							q.add(new Point(ny, nx, now.cnt + 1, now.dir));
						}
					}else 
						break;
				}
			}
			for(int dir = 0; dir<4; dir++) {
				if(now.dir == dir || visit[dir][now.y][now.x]) continue;
				visit[dir][now.y][now.x] = true;
				q.add(new Point(now.y, now.x, now.cnt + setDirection(now.dir, dir), dir));
			}
		}
		return 0;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[M][N];
		visit = new boolean[4][M][N];
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<N; j++) 
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		start = new Point(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1, 0, Integer.parseInt(st.nextToken())-1);
		st = new StringTokenizer(br.readLine());
		end = new Point(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1, 0, Integer.parseInt(st.nextToken())-1);
		System.out.println(bfs());
	}
	
	static class Point{
		int y;
		int x;
		int cnt;
		int dir;
		public Point(int y, int x, int cnt, int dir) {
			this.y = y;
			this.x = x;
			this.cnt = cnt;
			this.dir = dir;
		}
	}
}
