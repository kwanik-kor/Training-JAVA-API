package baekjun.bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Mirror2151 {
	static int N;
	static char map[][] = new char[51][51];
	static Point door[] = new Point[2];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		for(int i = 0; i<N; i++) {
			map[i] = br.readLine().toCharArray();
			for(int j = 0; j<N; j++) {
				if(map[i][j] == '#' && door[0] == null) 
					door[0] = new Point(i, j);
				else if(map[i][j] == '#' && door[0] != null)
					door[1] = new Point(i, j);
				
			}
		}
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
