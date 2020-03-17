package baekjun.bruteforce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class CandyGame3085 {
	static int N;
	static int max = 1;
	static int dy[] = {0, 1};
	static int dx[] = {1, 0};
	
	static void countMaxCandy(String[][] map) {
		for(int i = 0; i<N; i++) {
			int cnt_row = 1;
			int cnt_col = 1;
			for(int j = 1; j<N; j++) {
				if(map[i][j].equals(map[i][j-1]))
					cnt_row++;
				else {
					max = Math.max(max, cnt_row);
					cnt_row = 1;
				}
				
				if(map[j][i].equals(map[j-1][i]))
					cnt_col++;
				else {
					max = Math.max(max, cnt_col);
					cnt_col = 1;
				}
				
			}
			max = Math.max(Math.max(max, cnt_row), cnt_col);
		}
	}
	
	static void swap(String[][] map, int y, int x, int ny, int nx) {
		String tmp = map[y][x];
		map[y][x] = map[ny][nx];
		map[ny][nx] = tmp;
	}
	
	static void solve(String[][] map) {
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				for(int k = 0; k<2; k++) {
					int ny = i + dy[k];
					int nx = j + dx[k];
					if(ny < N && nx < N) {
						swap(map, i, j, ny, nx);
						countMaxCandy(map);
						swap(map, i, j, ny, nx);
					}
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		String map[][] = new String[N][N];
		for(int i = 0; i<N; i++) {
			String tmp[] = br.readLine().split("");
			for(int j = 0; j<N; j++) 
				map[i][j] = tmp[j];
		}
		solve(map);
		bw.write(max + "");
		bw.flush();
		bw.close();
		br.close();
	}

}
