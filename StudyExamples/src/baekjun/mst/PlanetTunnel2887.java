package baekjun.mst;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class PlanetTunnel2887 {
	static int N, parent[];
	static Planet galaxy[];
	static PriorityQueue<Edge> list = new PriorityQueue<>();
	static StringTokenizer st;
	
	
	static boolean isSameParent(int a, int b) {
		if(find(a) == find(b)) return true;
		return false;
	}
	
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a != b) parent[b] = a;
	}
	
	static int find(int node) {
		if(parent[node] == node) return node;
		return parent[node] = find(parent[node]);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		parent = new int[N];
		galaxy = new Planet[N];
		for(int i = 0; i<N; i++) {
			parent[i] = i;
			st = new StringTokenizer(br.readLine());
			galaxy[i] = new Planet(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), i);
		}
		
		Comparator<Planet> cp = (p1, p2) -> p1.x < p2.x ? -1 : 1;
		Arrays.sort(galaxy, cp);
		for(int i = 1; i<N; i++)
			list.add(new Edge(galaxy[i-1].idx, galaxy[i].idx, Math.abs(galaxy[i-1].x - galaxy[i].x)));
		
		cp = (p1, p2) -> p1.y < p2.y ? -1 : 1;
		Arrays.sort(galaxy, cp);
		for(int i = 1; i<N; i++)
			list.add(new Edge(galaxy[i-1].idx, galaxy[i].idx, Math.abs(galaxy[i-1].y - galaxy[i].y)));
		
		cp = (p1, p2) -> p1.z < p2.z ? -1 : 1;
		Arrays.sort(galaxy, cp);
		for(int i = 1; i<N; i++)
			list.add(new Edge(galaxy[i-1].idx, galaxy[i].idx, Math.abs(galaxy[i-1].z - galaxy[i].z)));
		
		long sum = 0;
		int cnt = 0;
		while(cnt < N && !list.isEmpty()) {
			Edge e = list.poll();
			if(!isSameParent(e.x, e.y)) {
				union(e.x, e.y);
				cnt++;
				sum += e.dist;
			}
		}
		bw.write(sum+"\n");
		bw.flush();
		bw.close();
		br.close();
	}
	
	static class Planet{
		int x;
		int y;
		int z;
		int idx;
		public Planet(int x, int y, int z, int idx) {
			this.x = x;
			this.y = y;
			this.z = z;
			this.idx = idx;
		}
	}
	
	static class Edge implements Comparable<Edge>{
		int x;
		int y;
		long dist;
		public Edge(int x, int y, long dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
		@Override
		public int compareTo(Edge e) {
			long result = this.dist - e.dist;
			return result >= 0 ? 1 : -1;
		}
	}
}
