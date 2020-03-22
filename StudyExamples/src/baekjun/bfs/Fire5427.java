package baekjun.bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Fire5427 {
	static int h, w;
	static char[][] map;
	static Queue<Point> fire, man;
	static int[] dy = {0, 1, 0, -1};
	static int[] dx = {1, 0, -1, 0};
	static int INF = 987654321;
	
	static int bfs() {
		int cnt = 0;
		while(true) {
			cnt++;
			int mansz = man.size();
			if(mansz == 0) {
				cnt = INF;
				break;
			}
			for(int i = 0; i<mansz; i++) {
				Point cur = man.poll();
				for(int dir = 0; dir<4; dir++) {
					int ny = cur.y + dy[dir];
					int nx = cur.x + dx[dir];
					if(ny < 0 || nx < 0 || ny >= h || nx >= w) 
						return cnt;
					else {
						if(map[ny][nx] == '.') {
							map[ny][nx] = '@';
							man.add(new Point(ny, nx));
						}
					}
				}
			}
			
			int firesz = fire.size();
			for(int i = 0; i<firesz; i++) {
				Point cur = fire.poll();
				for(int dir = 0; dir<4; dir++) {
					int ny = cur.y + dy[dir];
					int nx = cur.x + dx[dir];
					if(ny >= 0 && nx >= 0 && ny < h && nx < w && map[ny][nx] != '#') {
						map[ny][nx] = '*';
						fire.add(new Point(ny, nx));
					}
				}
			}
		}
		return cnt;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCase = Integer.parseInt(br.readLine());
		for(int t = 0; t<testCase; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			map = new char[h][w];
			man = new LinkedList<Point>();
			fire = new LinkedList<Point>();
			for(int i = 0; i<h; i++) {
				String tmp = br.readLine();
				for(int j = 0; j<w; j++) {
					map[i][j] = tmp.charAt(j);
					if(map[i][j] == '*')
						fire.add(new Point(i, j));
					if(map[i][j] == '@')
						man.add(new Point(i, j));
				}
			}
			int ret = bfs();
			bw.write((ret == INF)? "IMPOSSIBLE\n" : ret + "\n");
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
