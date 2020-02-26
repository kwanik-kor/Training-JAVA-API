package baekjun.mst;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Constellation4386 {
	static int N, parent[];
	static Star stars[];
	static ArrayList<Edge> list = new ArrayList<>();
	static StringTokenizer st;
	
	static double getDist(int a, int b) {
		double x = Math.abs(stars[a].x - stars[b].x);
		double y = Math.abs(stars[a].y - stars[b].y);
		return Math.sqrt(x*x + y*y);
	}
	
	static boolean isSameParent(int a, int b) {
		a = find(a);
		b = find(b);
		if(a == b) return true;
		return false;
	}
	
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a != b)
			parent[b] = a;
	}
	
	static int find(int node) {
		if(parent[node] == node) return node;
		return parent[node] = find(parent[node]);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		stars = new Star[N+1];
		parent = new int[N+1];
		for(int i = 1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			stars[i] = new Star(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()));
			parent[i] = i;
		}
		for(int i = 1; i<=N-1; i++) {
			for(int j = i+1; j<=N; j++)
				list.add(new Edge(i, j, getDist(i, j)));
		}
		Collections.sort(list);
		int cnt = 0;
		double sum = 0.0;
		for(Edge e : list) {
			if(!isSameParent(e.x, e.y)) {
				sum += e.val;
				union(e.x, e.y);
				if(++cnt == N-1) break;
			}
		}
		bw.write(String.format("%.2f", sum));
		bw.flush();
		bw.close();
		br.close();
	}
	
	static class Star{
		double x;
		double y;
		public Star(double x, double y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static class Edge implements Comparable<Edge>{
		int x;
		int y;
		double val;
		public Edge(int x, int y, double val) {
			this.x = x;
			this.y = y;
			this.val = val;
		}
		@Override
		public int compareTo(Edge e) {
			double result = this.val - e.val;
			return result >= 0.0 ? 1 : -1;
		}
	}
}
