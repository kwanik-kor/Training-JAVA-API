package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ColorPaper18246 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] loc = new int[1500][1500];
		StringBuilder sb = new StringBuilder("");
		for(int i = 0; i<N+M; i++) {
			st = new StringTokenizer(br.readLine());
			int y1 = Integer.parseInt(st.nextToken());
			int x1 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			if(i<N) {
				for(int a = y1; a<y2; a++) {
					for(int b = x1; b<x2; b++) {
						loc[a][b]++;
					}
				}
			}else {
				int max = 0;
				for(int a = y1; a<y2; a++) {
					for(int b = x1; b<x2; b++) {
						if(loc[a][b] > max)
							max = loc[a][b];
					}
				}
				sb.append(max + "\n");
			}
			
		}
		System.out.println(sb.toString());
		br.close();
	}
}
