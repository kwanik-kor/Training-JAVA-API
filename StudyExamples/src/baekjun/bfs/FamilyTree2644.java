package baekjun.bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class FamilyTree2644 {
	static int N;
	static ArrayList<Integer> adj[];
	static int visit[];
	
	static void bfs(int start, int end) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		visit[start] = 1;
		while(!q.isEmpty()) {
			int now = q.poll();
			if(now == end) break;
			for(Integer next : adj[now]) {
				if(visit[next] != 0) continue;
				visit[next] = visit[now] + 1;
				q.add(next);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		adj = new ArrayList[N+1];
		visit = new int[N+1];
		for(int i = 1; i<=N; i++)
			adj[i] = new ArrayList<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(br.readLine());
		while(m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			adj[p].add(c);
			adj[c].add(p);
		}
		bfs(start, end);
		int ans = (visit[end] == 0)? -1 : visit[end] - 1;
		bw.write(ans + "");
		bw.flush();
		bw.close();
		br.close();
	}

}
