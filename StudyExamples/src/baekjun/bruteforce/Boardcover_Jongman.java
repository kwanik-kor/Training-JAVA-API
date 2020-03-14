package baekjun.bruteforce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boardcover_Jongman {
	static int H, W;
	static int fraction[][][] = {
			{{0, 0}, {1, 0}, {0, 1}},
			{{0, 0}, {1, 0}, {1, 1}},
			{{0, 0}, {0, 1}, {1, 1}},
			{{0, 0}, {1, 0}, {1, -1}}
	};
	
	static boolean cover(int y, int x, int type, int map[][], int color) {
		boolean flag = true;
		for(int i = 0; i<3; i++) {
			int dy = y + fraction[type][i][0];
			int dx = x + fraction[type][i][1];
			if(dy < 0 || dx < 0 || dy >= H || dx >= W) {
				flag = false;
			}else if((map[dy][dx] += color) > 1) {
				flag = false;
			}
		}
		return flag;
	}
	
	static int countCombination(int map[][]) {
		int y = -1;
		int x = -1;
		for(int i = 0; i<H; i++) {
			for(int j = 0; j<W; j++) {
				if(map[i][j] == 0) {
					y = i;
					x = j;
					break;
				}
			}
			if(y != -1) break;
		}
		if(y == -1) return 1;
		int cnt = 0;
		for(int type = 0; type<4; type++) {
			if(cover(y, x, type, map, 1))
				cnt += countCombination(map);
			cover(y, x, type, map, -1);
		}
		return cnt;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCase = Integer.parseInt(br.readLine());
		for(int t = 0; t<testCase; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			int map[][] = new int[H][W];
			int white = 0;
			for(int i = 0; i<H; i++) {
				String tmp = br.readLine();
				for(int j = 0; j<W; j++) {
					if(tmp.charAt(j) == '#')
						map[i][j] = 1;
					if(map[i][j] == 0) white++;
				}
			}
			if(white % 3 != 0) {
				bw.write("0\n");
				continue;
			}
			bw.write(countCombination(map) + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
