package baekjun.bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class WalkWithBeer9205 {
	static ArrayList<Point> list;
	static int[][] d;
	static final int MAX = 102;
	
	static void floyd(int n) {
		for(int k = 0; k<n; k++) {
			for(int i = 0; i<n; i++) {
				for(int j = 0; j<n; j++) {
					if(d[i][j] > d[i][k] + d[k][j])
						d[i][j] = d[i][k] + d[k][j];
				}
			}
		}
	}
	
	static int getDistance(Point a, Point b) {
		return Math.abs(a.y - b.y) + Math.abs(a.x - b.x);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			int n = Integer.parseInt(br.readLine()) + 2;
			list = new ArrayList<Point>();
			d = new int[MAX][MAX];
			for(int i = 0; i<n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				list.add(new Point(y, x));
			}
			for(int i = 0; i<n; i++) 
				for(int j = 0; j<n; j++)
					d[i][j] = MAX;
			for(int i = 0; i<n; i++) {
				for(int j = 0; j<n; j++) {
					if(i == j) continue;
					if(getDistance(list.get(i), list.get(j)) <= 1000)
						d[i][j] = 1;
				}
			}
			floyd(n);
			n-=2;
			if(d[0][n+1] > 0 && d[0][n+1] < MAX)
				bw.write("happy\n");
			else
				bw.write("sad\n");
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
