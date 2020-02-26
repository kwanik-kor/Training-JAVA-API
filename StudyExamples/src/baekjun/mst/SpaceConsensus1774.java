package baekjun.mst;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


public class SpaceConsensus1774 {
	static int N, M, parent[];
	static God map[];
	static ArrayList<Edge> list = new ArrayList<>();
	static StringTokenizer st;
	
	static boolean isSameParent(int a, int b) {
		if(find(a) != find(b)) return false;
		return true;
	}
	
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a!=b) parent[b] = a;
	}
	
	static int find(int node) {
		if(parent[node] == node) return node;
		return parent[node] = find(parent[node]);
	}
	
	static double getDistance(int a, int b) {
		double x = Math.abs(map[a].x - map[b].x);
		double y = Math.abs(map[a].y - map[b].y);
		return Math.sqrt(x*x + y*y);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		parent = new int[N+1];
		map = new God[N+1];
		for(int i = 1; i<=N; i++) {
			parent[i] = i;
			st = new StringTokenizer(br.readLine());
			map[i] = new God(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		for(int i = 1; i<=M; i++) {
			st = new StringTokenizer(br.readLine());
			union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		for(int i = 1; i<=N-1; i++) {
			for(int j = i+1; j<=N; j++) {
				if(!isSameParent(i, j)) 
					list.add(new Edge(i, j, getDistance(i, j)));
			}
		}
		Collections.sort(list);
		double sum = 0;
		for(Edge e : list) {
			if(!isSameParent(e.x, e.y)) {
				sum += e.dist;
				union(e.x, e.y);
			}
		}
		bw.write(String.format("%.2f", sum));
		bw.flush();
		bw.close();
		br.close();
	}
	
	static class God{
		int x;
		int y;
		public God(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static class Edge implements Comparable<Edge>{
		int x;
		int y;
		double dist;
		public Edge(int x, int y, double dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
		@Override
		public int compareTo(Edge e) {
			double result = this.dist - e.dist;
			return (result >= 0.0)? 1 : -1;
		}
	}
}
