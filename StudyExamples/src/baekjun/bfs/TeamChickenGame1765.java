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

public class TeamChickenGame1765 {
	static int N;
	static ArrayList<Integer> adj[], enemy[];
	static int[] team;
	
	static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		for(int i = 1; i<=N; i++) {
			if(team[i] != 0) continue;
			int num = 0;
			for(int j = 1; j<=N; j++)
				num = Math.max(num, team[j]);
			team[i] = num + 1;
			q.add(i);
			while(!q.isEmpty()) {
				int now = q.poll();
				for(Integer next : adj[now]) {
					if(team[next] != 0) continue;
					team[next] = team[now];
					q.add(next);
				}
				for(Integer next : enemy[now]) {
					for(Integer next2 : enemy[next]) {
						if(team[next2] != 0) continue;
						team[next2] = team[now];
						q.add(next2);
					}
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		adj = new ArrayList[N+1];
		enemy = new ArrayList[N+1];
		team = new int[N+1];
		for(int i = 1; i<=N; i++){
			adj[i] = new ArrayList<>();
			enemy[i] = new ArrayList<>();
		}
		int m = Integer.parseInt(br.readLine());
		while(m-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char flag = st.nextToken().charAt(0);
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(flag == 'F') {
				adj[a].add(b);
				adj[b].add(a);
			}else {
				enemy[a].add(b);
				enemy[b].add(a);
			}
		}
		bfs();
		int max = 0;
		for(int i = 1; i<=N; i++)
			max = Math.max(max, team[i]);
		bw.write(max + "");
		bw.flush();
		bw.close();
		br.close();
	}

}
