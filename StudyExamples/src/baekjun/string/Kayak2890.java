package baekjun.string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Kayak2890 {
	static boolean visit[] = new boolean[10];
	static int rankArr[] = new int[10];
	static char[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		for(int i = 0; i<R; i++) {
			String tmp = br.readLine();
			for(int j = 0; j<C; j++)
				map[i][j] = tmp.charAt(j);
		}
		int rank = 1;
		for(int j = C-2; j>=1; j--) {
			boolean flag = false;
			for(int i = 0; i<R; i++) {
				char c = map[i][j];
				if(c == '.') continue;
				int num = c - '0';
				if(!visit[num]) {
					flag = true;
					rankArr[num] = rank;
					visit[num] = true;
				}
			}
			if(flag) rank++;
		}
		for(int i = 1; i<=9; i++) 
			bw.write(rankArr[i] + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

}
