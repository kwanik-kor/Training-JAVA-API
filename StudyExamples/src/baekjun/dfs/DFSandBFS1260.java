package baekjun.dfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class DFSandBFS1260 {
	static StringBuilder sb = new StringBuilder();
	
	static class Graph{
		private int V;
		private LinkedList<Integer> adj[];
		
		Graph(int v){
			V = v;
			adj = new LinkedList[v+1];
			for(int i = 1; i<=v; i++)
				adj[i] = new LinkedList();
		}
		
		void addEdge(int v, int w) {
			adj[v].add(w);
			adj[w].add(v);
		}
		
		void sortList() {
			for(int i = 1; i<=V; i++) {
				Collections.sort(adj[i]);
			}
		}
		
		void DFSUtil(int v, boolean visited[]) {
			sb.append(v + " ");
			visited[v] = true;
			Iterator<Integer> i = adj[v].listIterator();
			while(i.hasNext()) {
				int n = i.next();
				if(!visited[n])
					DFSUtil(n, visited);
			}
		}
		
		void DFS(int v) {
			boolean visited[] = new boolean[V+1];
			DFSUtil(v, visited);
		}
		
		void BFS(int v) {
			boolean visited[] = new boolean[V+1];
			LinkedList<Integer> queue = new LinkedList<Integer>();
			visited[v] = true;
			queue.add(v);
			while(!queue.isEmpty()) {
				v = queue.poll();
				sb.append(v + " ");
				Iterator<Integer> i = adj[v].listIterator();
				while(i.hasNext()) {
					int n = i.next();
					if(!visited[n]) {
						visited[n] = true;
						queue.add(n);
					}
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		Graph g = new Graph(N);
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			g.addEdge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		g.sortList();
		g.DFS(V);
		sb.append("\n");
		g.BFS(V);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}
