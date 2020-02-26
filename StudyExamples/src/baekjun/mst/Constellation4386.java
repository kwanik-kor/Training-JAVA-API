package baekjun.mst;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Constellation4386 {
	static int N, parent[];
	static Edge list[];
	static StringTokenizer st;
	
	static double findMinDist(double minDist, int idx) {
		Edge now = list[idx];
		double min = Integer.MAX_VALUE;
		int minIdx = 0;
		for(int i = 1; i<=N; i++) {
			if(i != idx && !isSameParent(i, idx)) {
				double dist = calcDist(idx, i);
				if(min > dist) {
					min = dist;
					minIdx = i;
				}
			}
		}
		
		if(min == Integer.MAX_VALUE) return minDist;
		else {
			union(idx, minIdx);
			minDist += min;
			return findMinDist(minDist, minIdx);
		}
	}
	
	static double calcDist(int a, int b) {
		double x = Math.abs(list[a].x - list[b].x);
		double y = Math.abs(list[a].y - list[b].y);
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
		parent = new int[N+1];
		list = new Edge[N+1];
		for(int i = 1; i<=N; i++) 
			parent[i] = i;
		for(int i = 1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			double x = Double.parseDouble(st.nextToken());
			double y = Double.parseDouble(st.nextToken());
			list[i] = new Edge(x, y);
		}
		bw.write(String.format("%.2f", findMinDist(0,1)));
		bw.flush();
		bw.close();
		br.close();
	}
	
	static class Edge{
		double x;
		double y;
		public Edge(double x, double y) {
			this.x = x;
			this.y = y;
		}
	}
}
