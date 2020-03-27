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

public class Sheep3184 {
	static int R, C;
	static int map[][];
	static int territory[][];
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	
	static ArrayList<Point> sheep = new ArrayList<>();
	static ArrayList<Point> wolf = new ArrayList<>();
	
	static void bfs(int y, int x, int num) {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(y, x));
		map[y][x] = num;
		while(!q.isEmpty()) {
			Point now = q.poll();
			for(int i = 0; i<4; i++) {
				int ny = now.y + dy[i];
				int nx = now.x + dx[i];
				if(ny < 0 || nx < 0 || ny >= R || nx >= C || map[ny][nx] == -1) continue;
				if(map[ny][nx] == 0) {
					map[ny][nx] = num;
					q.add(new Point(ny, nx));
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		territory = new int[R][C];
		for(int i = 0; i<R; i++) {
			String tmp = br.readLine();
			for(int j = 0; j<C; j++) {
				map[i][j] = 0;
				if(tmp.charAt(j) == 'v')
					wolf.add(new Point(i, j));
				if(tmp.charAt(j) == 'o')
					sheep.add(new Point(i, j));
				else if (tmp.charAt(j) == '#')
					map[i][j] = -1;
			}
		}
		int num = 0;
		for(int i = 0; i<R; i++) {
			for(int j = 0; j<C; j++) {
				if(map[i][j] == 0)
					bfs(i, j, ++num);
			}
		}
		territory = new int[num+1][2];
		for(Point p : sheep) 
			territory[map[p.y][p.x]][0]++;
		for(Point p : wolf)
			territory[map[p.y][p.x]][1]++;
		int s_cnt = 0;
		int w_cnt = 0;
		for(int i = 1; i<=num; i++) {
			if(territory[i][0] > territory[i][1])
				s_cnt += territory[i][0];
			else
				w_cnt += territory[i][1];
		}
		bw.write(s_cnt + " " +  w_cnt);
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
