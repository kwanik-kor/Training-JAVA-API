package baekjun.simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Snail2_1952 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		boolean map[][] = new boolean[M][N];
		int dx[] = {0, 1, 0, -1};
		int dy[] = {1, 0, -1, 0};
		int cnt = 0;
		int x = 0, y = 0;
		int dir = 0;
		while(true) {
			if(map[x][y]) break;
			map[x][y] = true;
			int nx = x + dx[dir];
			int ny = y + dy[dir];
			if(nx < 0 || ny < 0 || nx >= M || ny >= N || map[nx][ny]) {
				dir = (dir + 1)%4;
				nx = x + dx[dir];
				ny = y + dy[dir];
				cnt++;
			}
			x = nx;
			y = ny;
		}
		bw.write(cnt-1 + "");
		bw.flush();
		bw.close();
		br.close();
	}

}
