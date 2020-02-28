package baekjun.disjoint_set;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class ConnectedComponent11724 {
	static int parent[];
	static int N, M;
	static StringTokenizer st;
	
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a!=b) parent[b] = a;
	}
	
	static int find(int node) {
		if(parent[node] == node) return node;
		return parent[node] = find(parent[node]);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		parent = new int[N+1];
		for(int i = 1; i<=N; i++)
			parent[i] = i;
		for(int m = 0; m<M; m++) {
			st = new StringTokenizer(br.readLine());
			union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		HashSet<Integer> set = new HashSet<>();
		for(int i = 1; i<=N; i++)
			set.add(find(i));
		bw.write(set.size() + "");
		bw.flush();
		bw.close();
		br.close();
	}

}
