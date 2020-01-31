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

public class BipartiteGraph1707 {
	static int N, M, RED = 1, BLUE = -1;
	static boolean chkBipartite;
	static int colors[];
	
	static class Graph {
		private LinkedList<Integer> adj[];
		
		Graph(){
			adj = new LinkedList[N+1];
			for(int i = 1; i<=N; i++)
				adj[i] = new LinkedList<Integer>();
		}
		
		void addEdge(int a, int b) {
			adj[a].add(b);
			adj[b].add(a);
		}
		
		void BFS(int start, int color) {
			Queue<Integer> q = new LinkedList<Integer>();
			q.add(start);
			colors[start] = color;
			while(!q.isEmpty() && chkBipartite) {
				int x = q.poll();
				Iterator<Integer> iter = adj[x].listIterator();
				while(iter.hasNext()) {
					int next = iter.next();
					if(colors[next] == 0) {
						q.add(next);
						colors[next] = colors[x] * -1;
					}
					else if(colors[next] + colors[x] != 0) {
						chkBipartite = false;
						break;
					}
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int Testcase = Integer.parseInt(br.readLine());
		for(int t = 0; t < Testcase; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			Graph g = new Graph();
			chkBipartite = true;
			colors = new int[N+1];
			for(int m = 0; m<M; m++) {
				st = new StringTokenizer(br.readLine());
				g.addEdge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			for(int i = 1; i<=N; i++) {
				if(!chkBipartite) break;
				if(colors[i] == 0) g.BFS(i, RED);
			}
			bw.write(chkBipartite? "YES\n" : "NO\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
