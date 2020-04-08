package baekjun.string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class MonsterTruck2897 {
	static int R, C;
	static int[] destroy = new int[5];
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		for(int i = 0; i<R; i++) {
			String tmp = br.readLine();
			for(int j = 0; j<C; j++){
				char c = tmp.charAt(j);
				if(c == '#') map[i][j] = -1;
				else if(c == '.') map[i][j] = 0;
				else map[i][j] = 1;
			}
		}
		for(int i = 0; i<R-1; i++) {
			for(int j = 0; j<C-1; j++) {
				int cnt = 0;
				if(map[i][j] == -1 || map[i+1][j] == -1 || map[i][j+1] == -1 || map[i+1][j+1] == -1) continue;
				cnt += map[i][j] + map[i+1][j] + map[i][j+1] + map[i+1][j+1];
				destroy[cnt]++;
			}
		}
		for(int i = 0; i<5; i++)
			bw.write(destroy[i] + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

}
