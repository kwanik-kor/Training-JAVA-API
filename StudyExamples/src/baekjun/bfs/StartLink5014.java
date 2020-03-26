package baekjun.bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class StartLink5014 {
	static int[] building;
	static int[] dir = new int[2];
	static int F, S, G, U, D;
	
	static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		building[S] = 1;
		dir[0] = U;
		dir[1] = -D;
		q.add(S);
		while(!q.isEmpty()) {
			int now = q.poll();
			for(int i = 0; i<2; i++) {
				int next = now + dir[i];
				if(next < 1 || next >F || building[next] != 0) continue;
				building[next] = building[now] + 1;
				q.add(next);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		F = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		U = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		building = new int[F + 1];
		bfs();
		bw.write((building[G] == 0)? "use the stairs" : building[G] - 1 + "");
		bw.flush();
		bw.close();
		br.close();
	}

}
