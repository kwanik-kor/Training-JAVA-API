package baekjun.bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class KevinBacon1389 {
	static int N, M;
	static int kevin[][];
	
	static class Graph{
		private LinkedList<Integer> adj[];
		
		Graph(){
			adj = new LinkedList[N+1];
			for(int i = 1; i<=N; i++)
				adj[i] = new LinkedList();
		}
		
		void addEdge(int n, int m) {
			if(!adj[n].contains(m)) {
				adj[n].add(m);
				adj[m].add(n);
			}
		}
		
		void BFS(int start, int end) {
			int visit[] = new int[N+1];
			Queue<Integer> q = new LinkedList<>();
			visit[start] = 1;
			int result = 0;
			q.add(start);
			while(!q.isEmpty()) {
				int temp = q.poll();
				if(temp == end) {
					result = visit[temp];
					break;
				}
				Iterator<Integer> i = adj[temp].listIterator();
				while(i.hasNext()) {
					int n = i.next();
					if(visit[n] == 0) {
						visit[n] = visit[temp] + 1;
						q.add(n);
					}
				}
			}
			kevin[start][end] = result-1;
			kevin[end][start] = result-1;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		kevin = new int[N+1][N+1];
		Graph g = new Graph();
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			g.addEdge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		for(int i = 1; i<=N; i++) {
			for(int j = i+1; j<=N; j++) {
				g.BFS(i, j);
			}
		}
		int min = 101;
		int idx = 0;
		for(int i = 1; i<=N; i++) {
			int sum = 0;
			for(int j = 1; j<=N; j++)
				sum += kevin[i][j];
			if(sum < min) {
				min = sum;
				idx = i;
			}
		}
		bw.write(idx+"");
		bw.flush();
		bw.close();
		br.close();
	}

}
