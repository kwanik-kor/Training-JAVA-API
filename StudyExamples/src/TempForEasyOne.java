import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class TempForEasyOne {
	static int N, M;
	static int result[][];
	
	public static void bfs(LinkedList<Point> list) {
		Queue<Point> q = new LinkedList<>();
		for(Point p : list)
			q.add(p);
		while(!q.isEmpty()) {
			Point now = q.poll();
			int dx = now.x;
			int dy = now.y;
			if(dy + 1 < M && result[dx][dy+1] < 0) {
				result[dx][dy+1] = result[dx][dy] + 1;
				q.add(new Point(dx, dy+1));
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		result = new int[N][M];
		LinkedList<Point> list = new LinkedList<Point>();
		for(int i = 0; i<N; i++) {
			String tmp = br.readLine();
			for(int j = 0; j<M; j++) {
				if(tmp.charAt(j) == 'c'){
					list.add(new Point(i, j));
					result[i][j] = 0;
				}else result[i][j] = -1;
			}
		}
		bfs(list);
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				bw.write(result[i][j] + " ");
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	static class Point{
		int x;
		int y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
