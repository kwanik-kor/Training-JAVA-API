package baekjun.simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class RobotVacum14503 {
	static int N, M;
	//ºÏ µ¿ ¼­ ³²
	static int dy[] = {-1, 0, 1, 0};
	static int dx[] = {0, 1, 0, -1};
	static int map[][];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		st = new StringTokenizer(br.readLine());
		Point robot = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		for(int i = 0; i<N; i++) {
			//resting also on today
			//and the last rest but today is real last
			//first work on hubilon It was quite cool.
			//I should study linux
			//full3
		}
	}
	
	static class Point{
		int y;
		int x; 
		int dir;
		public Point(int y, int x, int dir) {
			this.y = y;
			this.x = x;
			this.dir = dir;
		}
	}
}
