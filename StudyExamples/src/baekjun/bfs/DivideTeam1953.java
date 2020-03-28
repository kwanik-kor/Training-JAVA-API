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

public class DivideTeam1953 {
	static int n;
	static int visit[];
	static ArrayList<Integer> adj[];
	static ArrayList<Integer> blue = new ArrayList<>();
	static ArrayList<Integer> red = new ArrayList<>();
	
	static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		for(int i = 1; i<=n; i++) {
			if(visit[i] != 0) continue;
			visit[i] = 1;
			q.add(i);
			while(!q.isEmpty()) {
				int now = q.poll();
				for(Integer next : adj[now]) {
					if(visit[next] != 0) continue;
					visit[next] = visit[now] * (-1);
					q.add(next);
				}
			}
		}
		for(int i = 1; i<=n; i++) {
			if(visit[i] == 1) blue.add(i);
			else red.add(i);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(br.readLine());
		adj = new ArrayList[n+1];
		visit = new int[n+1];
		for(int i = 1; i<=n; i++) 
			adj[i] = new ArrayList<>();
		for(int i = 1; i<=n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			while(t-- > 0) {
				int j = Integer.parseInt(st.nextToken());
				adj[i].add(j);
				adj[j].add(i);
			}
		}
		bfs();
		bw.write(blue.size() + "\n");
		for(Integer i : blue)
			bw.write(i + " ");
		bw.write("\n" + red.size() + "\n");
		for(Integer i : red)
			bw.write(i + " ");
		bw.flush();
		bw.close();
		br.close();
	}
}
