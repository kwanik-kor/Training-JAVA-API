package baekjun.functions;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Star10997 {
	static int N, height, width;
	static char map[][];
	static int cnt = 0;
	static String direction[] = {"up", "right", "down", "left"};
	
	static void drawStar(int x, int y, int k, int dir) {
		if(N == 1) {
			map[0][0] = '*';
			return;
		}
		if(x == 0 && y == width) return;
		
		map[x][y] = '*';
		cnt++;
		if(cnt == k) {
			dir++;
			dir %= 4;
		}else if(cnt == 2*k - 1) {
			k += 2;
			dir++;
			dir %= 4;
			cnt = 1;
		}
		
		switch(direction[dir]) {
		case "up": x -= 1; break;
		case "right": y += 1; break;
		case "down": x += 1; break;
		case "left": y -= 1; break;
		}
		
		drawStar(x, y, k, dir);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		if(N == 1) {
			height = 1;
			width = 1;
		}else if(N >= 2) {
			height = 7;
			width = height - 2;
			for(int i = 3; i<=N; i++) {
				height += 4;
				width = height - 2;
			}
		}
		map = new char[height][width];
		for(int i = 0; i<height; i++) {
			for(int j = 0; j<width; j++) {
				map[i][j] = ' ';
			}
		}
		drawStar(height/2 + 1, width/2, 3, 0);
		for(int i = 0; i<height; i++) {
			for(int j = 0; j<width; j++) {
				bw.write(map[i][j]);
				if(i == 1 && j == 0) break;
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
