package baekjun.bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ChessKnight7562 {
	static int[][] board;
	static boolean[][] visit;
	static int N;
	static Point start, end;
	static int x[] = {2, 2, -2, -2, 1, 1, -1, -1};
	static int y[] = {1, -1, 1, -1, 2, -2, 2, -2};
	
	static int BFS() {
		int result = 0;
		Queue<Point> q = new LinkedList<>();
		q.add(start);
		while(!q.isEmpty()) {
			Point p = q.poll();
			if(p.x == end.x && p.y == end.y) {
				result = board[p.x][p.y];
				break;
			}
			for(int i = 0; i<8; i++) {
				int dx = p.x + x[i];
				int dy = p.y + y[i];
				if(dx < 0 || dx >= N || dy < 0 || dy >= N || visit[dx][dy]) continue;
				q.add(new Point(dx, dy));
				visit[dx][dy] = true;
				board[dx][dy] = board[p.x][p.y] + 1; 
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int t = 0; t<T; t++) {
			N = Integer.parseInt(br.readLine());
			board = new int[N][N];
			visit = new boolean[N][N];
			st = new StringTokenizer(br.readLine());
			start = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			st = new StringTokenizer(br.readLine());
			end = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			bw.write(BFS() + "\n");
		}
		bw.flush();
		br.close();
		bw.close();
	}
	
	static class Point{
		int x;
		int y;
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
