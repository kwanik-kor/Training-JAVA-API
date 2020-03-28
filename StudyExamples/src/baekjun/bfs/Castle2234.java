package baekjun.bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Castle2234 {
	static int n, m;
	static int[][] map, room;
	static int[] ruimte = new int[2501];
	//서북동남 1 2 4 8
	static int[] dy = {0, -1, 0, 1};
	static int[] dx = {-1, 0, 1, 0};
	static int[] bit = {1, 2, 4, 8};
	static ArrayList<Integer> list = new ArrayList<>();
	
	static int getBiggerRoom(int y, int x) {
		int maxSize = ruimte[room[y][x]];
		for(int i = 0; i<4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if(ny < 0 || nx < 0 || ny >= m || nx >= n) continue;
			if(room[y][x] == room[ny][nx]) continue;
			if((map[y][x] | bit[i]) == map[y][x])
				maxSize = Math.max(maxSize, ruimte[room[y][x]] + ruimte[room[ny][nx]]);
		}
		return maxSize;
	}
	
	static int bfs(int y, int x, int num) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(y, x));
		room[y][x] = num;
		int size = 1;
		while(!q.isEmpty()) {
			Point now = q.poll();
			for(int dir = 0; dir<4; dir++) {
				//진행하려는 방향에 벽이 있다면
				if((map[now.y][now.x] | bit[dir]) == map[now.y][now.x]) continue;
				int ny = now.y + dy[dir];
				int nx = now.x + dx[dir];
				if(ny < 0 || nx < 0 || ny >= m || nx >= n || room[ny][nx] != 0) continue;
				room[ny][nx] = num;
				size++;
				q.add(new Point(ny, nx));
			}
		}
		return size;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[m][n];
		room = new int[m][n];
		for(int i = 0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<n; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		int num = 0;
		int maxSize = 0;
		int biggerSize = 0;
		for(int i = 0; i<m; i++) {
			for(int j = 0; j<n; j++) { 
				if(room[i][j] == 0) {
					ruimte[++num] = bfs(i, j, num);
					maxSize = Math.max(maxSize, ruimte[num]);
				}
			}
		}
		for(int i = 0; i<m; i++) 
			for(int j = 0; j<n; j++)
				biggerSize = Math.max(biggerSize, getBiggerRoom(i, j));
		bw.write(num + "\n" + maxSize + "\n" + biggerSize);
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
