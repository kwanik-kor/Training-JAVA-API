package baekjun.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Chess1018 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[][] map = new char[N][M];
		for(int i = 0; i<N; i++) {
			String s = br.readLine();
			for(int j = 0; j<M; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		int min = 2500;
		for(int x = 0; x<N-7; x++) {
			for(int y = 0; y<M-7; y++) {
				int cnt_b = 0;
				for(int i = 0; i<8; i++) {
					for(int j = 0; j<8; j++) {
						if(i%2 == 0) {
							if(j%2 == 0) {
								if(map[x+i][y+j] != 'B')
									cnt_b++;
							}else {
								if(map[x+i][y+j] != 'W')
									cnt_b++;
							}
						}else {
							if(j%2 == 0) {
								if(map[x+i][y+j] != 'W')
									cnt_b++;
							}else {
								if(map[x+i][y+j] != 'B')
									cnt_b++;
							}
						}
					}
				}
				
				int cnt_w = 0;
				for(int i = 0; i<8; i++) {
					for(int j = 0; j<8; j++) {
						if(i%2 == 0) {
							if(j%2 == 0) {
								if(map[x+i][y+j] != 'W')
									cnt_w++;
							}else {
								if(map[x+i][y+j] != 'B')
									cnt_w++;
							}
						}else {
							if(j%2 == 0) {
								if(map[x+i][y+j] != 'B')
									cnt_w++;
							}else {
								if(map[x+i][y+j] != 'W')
									cnt_w++;
							}
						}
					}
				}
				int temp = (cnt_b < cnt_w)? cnt_b : cnt_w;
				if(temp<min)
					min = temp;
			}
		}
		System.out.println(min);
	}

}
