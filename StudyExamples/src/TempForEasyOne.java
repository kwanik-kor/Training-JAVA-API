import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class TempForEasyOne {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		boolean map[][] = new boolean[M][N];
		int x[] = {0, 1, 0, -1};
		int y[] = {1, 0, -1, 0};
		int dx = 0, dy = 0;
		int cnt = 0;
		int flag = 0;
		while(true) {
			if(map[dx][dy]) break;
			map[dx][dy] = true;
			int nx = dx + x[flag];
			int ny = dy + y[flag];
			if(nx < 0 || ny < 0 || nx >= M || ny >= N || map[nx][ny]) {
				flag = (flag+1)%4;
				nx = dx + x[flag];
				ny = dy + y[flag];
				cnt++;
			}
			dx = nx;
			dy = ny;
		}
		bw.write(cnt-1 + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
