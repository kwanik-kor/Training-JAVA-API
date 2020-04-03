package baekjun.bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Mineral2933 {
	static int R, C;
	static char[][] map;
	static int[][] cluster;
	static int[] stick;
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	
	static void shootFromLeft(int h) {
		int y = R - h + 1;
		for(int i = 1; i<=C; i++) {
			if(map[y][i] == 'x') {
				map[y][i] = '.';
				break;
			}
		}
	}
	
	static void shootFromRight(int h) {
		int y = R - h + 1;
		for(int i = C; i>=1; i--) {
			if(map[y][i] == 'x') {
				map[y][i] = '.';
				break;
			}
		}
	}
	
	static void fallMineral(int clusterCnt) {
		boolean[] floorChk = new boolean[clusterCnt+1];
		for(int i = 1; i<=C; i++)
			if(cluster[R][i] != 0)
				floorChk[cluster[R][i]] = true;
		//땅에 붙어있지 않은 클러스터만 떨어뜨려주자.
		for(int k = 1; k<=clusterCnt; k++) {
			if(floorChk[k]) continue;
			
			ArrayList<Point> list = new ArrayList<Point>();
			for(int i = R; i>=1; i--)
				for(int j = 1; j<=C; j++) 
					if(cluster[i][j] == k)
						list.add(new Point(i, j));
			int min = 101;
			for(Point p : list) {
				int cnt = 0;
				int y = p.y;
				boolean flag = true;
				while(y < R) {
					y++;
					if(cluster[y][p.x] == 0)
						cnt++;
					else if(cluster[y][p.x]== k) {
						flag = false;
						break;
					}else
						break;
				}
				if(flag)
					min = Math.min(min, cnt);
			}
			for(Point p : list) {
				char tmp = map[p.y + min][p.x];
				map[p.y + min][p.x] = map[p.y][p.x];
				map[p.y][p.x] = tmp;
			}
		}
	}
	
	static void countCluster(int y, int x, int num) {
		Queue<Point> q = new LinkedList<Point>();
		cluster[y][x] = num;
		q.add(new Point(y, x));
		while(!q.isEmpty()) {
			Point now = q.poll();
			for(int dir = 0; dir<4; dir++) {
				int ny = now.y + dy[dir];
				int nx = now.x + dx[dir];
				if(ny < 1 || nx < 1 || ny > R || nx > C || map[ny][nx] == '.' || cluster[ny][nx] != 0) continue;
				cluster[ny][nx] = num;
				q.add(new Point(ny, nx));
			}
		}
	}
	
	static void solve(int N) {
		for(int n = 0; n<N; n++) {
			if(n%2 == 0) shootFromLeft(stick[n]);
			else shootFromRight(stick[n]);
			
			for(int i = 1; i<=R; i++)
				Arrays.fill(cluster[i], 0);
			int cnt = 0;
			for(int i = 1; i<=R; i++)
				for(int j = 1; j<=C; j++)
					if(map[i][j] == 'x' && cluster[i][j] == 0)
						countCluster(i, j, ++cnt);
			if(cnt == 1) continue;
			else fallMineral(cnt);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R+1][C+1];
		cluster = new int[R+1][C+1];
		for(int i = 1; i<=R; i++) {
			String str = br.readLine();
			for(int j = 1; j<=C; j++) 
				map[i][j] = str.charAt(j-1);
		}
		int N = Integer.parseInt(br.readLine());
		stick = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) 
			stick[i] = Integer.parseInt(st.nextToken());
		solve(N);
		for(int i = 1; i<=R; i++) {
			for(int j = 1; j<=C; j++)
				bw.write(map[i][j]);
			bw.write("\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	static class Point{
		int y;
		int x;
		public Point(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}
