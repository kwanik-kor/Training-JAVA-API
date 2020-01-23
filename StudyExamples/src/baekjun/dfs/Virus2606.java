package baekjun.dfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Virus2606 {
	static class Graph {
		private int N;
		private LinkedList<Integer> adj[];
		private ArrayList<Integer> arr = new ArrayList<>();
		
		Graph(int n){
			N = n;
			adj = new LinkedList[n+1];
			for(int i = 1; i<n+1; i++)
				adj[i] = new LinkedList<>();
		}
		
		void addNode(int a, int b) {
			adj[a].add(b);
			adj[b].add(a);
		}
		
		void DFS(int a) {
			boolean visit[] = new boolean[N+1];
			DFSUtil(a, visit);
		}
		
		void DFSUtil(int a, boolean visit[]) {
			arr.add(a);
			visit[a] = true;
			Iterator<Integer> i = adj[a].listIterator();
			while(i.hasNext()) {
				int n = i.next();
				if(!visit[n])
					DFSUtil(n, visit);
			}
		}
		
		int countVirusCom() {
			return arr.size() - 1;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Graph g = new Graph(Integer.parseInt(br.readLine()));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			g.addNode(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		g.DFS(1);
		bw.write(g.countVirusCom() + "");
		bw.flush();
		bw.close();
		br.close();
	}

}
