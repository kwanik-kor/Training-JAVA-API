package baekjun.bruteforce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class CrazyRobot1405 {
	static int N;
	//µ¿ ¼­ ³² ºÏ
	static int percent[] = new int[4];
	static int dy[] = {0, 0, 1, -1};
	static int dx[] = {1, -1, 0, 0};
	static double total = 0;
	
	static void solve(boolean visit[][], int y, int x, int cnt, double val) {
		if(cnt == N) {
			total += val;
			return;
		}
		for(int i = 0; i<4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			double next_val = val;
			if(!visit[ny][nx]) {
				next_val *= (double)percent[i] / 100;
				visit[ny][nx] = true;
				solve(visit, ny, nx, cnt + 1, next_val);
				visit[ny][nx] = false;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		for(int i = 0; i<4; i++)
			percent[i] = Integer.parseInt(st.nextToken());
		boolean visit[][] = new boolean[2*N+1][2*N+1];
		visit[N][N] = true;
		solve(visit, N, N, 0, 1);
		bw.write(total+"");
		bw.flush();
		bw.close();
		br.close();
	}

}
