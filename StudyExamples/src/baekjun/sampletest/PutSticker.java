package baekjun.sampletest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class PutSticker {
	static int N, M;
	static int r, c;
	static int[][] map;
	static int cntSticker;
	static StringTokenizer st;
	
	static boolean isPossible(int y, int x, int[][] sticker) {
		boolean flag = true;
		for(int i = 0; i<r; i++) {
			for(int j = 0; j<c; j++) {
				if(sticker[i][j] == 1 && map[y + i][x + j] == 1) {
					return flag = false;
				}
			}
		}
		if(flag) {
			for(int i = 0; i<r; i++) {
				for(int j = 0; j<c; j++){
					if(sticker[i][j] == 1) {
						cntSticker++;
						map[y + i][x + j] = 1;
					}
				}
			}
		}
		return flag;
	}
	
	static int[][] rotate(int[][] sticker){
		int[][] rotated = new int[c][r];
		for(int i = 0; i<c; i++) {
			for(int j =0; j<r; j++)
				rotated[i][j] = sticker[r-j-1][i];
		}
		int tmp = r;
		r = c;
		c = tmp;
		return rotated;
	}
	
	static void setPosition(int dir, int[][] sticker) {
		if(dir == 4) return;
		
		for(int i = 0; i <= N-r; i++) {
			for(int j = 0; j <= M-c; j++) {
				if(isPossible(i, j, sticker)) 
					return;
			}
		}
		setPosition(dir + 1, rotate(sticker));
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		int K = Integer.parseInt(st.nextToken());
		for(int k = 0; k<K; k++) {
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			int sticker[][] = new int[r][c];
			for(int i = 0; i<r; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j<c; j++)
					sticker[i][j] = Integer.parseInt(st.nextToken());
			}
			setPosition(0, sticker);
		}
		bw.write(cntSticker + "");
		bw.flush();
		bw.close();
		br.close();
	}

}
