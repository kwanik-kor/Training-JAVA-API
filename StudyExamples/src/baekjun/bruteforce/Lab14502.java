package baekjun.bruteforce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Lab14502 {
	static int N, M, max = 0;
	static int originMap[][];
	static int dx[] = {-1, 0, 1, 0};
	static int dy[] = {0, 1, 0, -1};
	static ArrayList<Point> canBuild = new ArrayList<>();
	
	static int getSizeOfSafe(int[][] map) {
		int cnt = 0;
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				if(map[i][j] == 0) cnt++;
			}
		}
		return cnt;
	}
	
	static void resetMap(int[][] map) {
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++)
				map[i][j] = originMap[i][j];
		}
	}
	
	static void spreadVirus(int[][] map) {
		Queue<Point> q = new LinkedList<Point>();
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				if(map[i][j] == 2)
					q.add(new Point(i, j));
			}
		}
		
		while(!q.isEmpty()) {
			Point now = q.poll();
			for(int i = 0; i<4; i++) {
				int ny = now.y + dy[i];
				int nx = now.x + dx[i];
				if(ny >= 0 && nx >= 0 && ny < N && nx < M && map[ny][nx] == 0) {
					map[ny][nx] = 2;
					q.add(new Point(ny, nx));
				}
			}
		}
	}
	
	static void selectWall(int toBuild, int[][] map, ArrayList<Integer> list) {
		if(toBuild == 0) {
			for(Integer i : list) {
				Point p = canBuild.get(i);
				map[p.y][p.x] = 1;
			}
			spreadVirus(map);
			max = Math.max(max, getSizeOfSafe(map));
			resetMap(map);
			return;
		}
		
		int small = list.isEmpty()? 0 : list.get(list.size() - 1) + 1;
		for(int next = small; next<canBuild.size(); next++) {
			list.add(next);
			selectWall(toBuild - 1, map, list);
			list.remove(list.size() - 1);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int map[][] = new int[N][M];
		originMap = new int[N][M];
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<M; j++) {
				originMap[i][j] = map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 0) canBuild.add(new Point(i, j));
			}
		}
		selectWall(3, map, new ArrayList<Integer>());
		bw.write(max + "");
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
