package baekjun.disjoint_set;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SetExpression1717 {
	static int n, m;
	static int parent[];
	static StringTokenizer st;
	
	static int getParent(int node) {
		if(parent[node] == node) 
			return node;
		return parent[node] = getParent(parent[node]);
	}
	
	static void union(int a, int b) {
		int parent1 = getParent(a);
		int parent2 = getParent(b);
		
		if(parent1 <= parent2) parent[parent2] = parent[parent1];
		else parent[parent1] = parent[parent2];
	}
	
	static boolean find(int a, int b) {
		a = getParent(a);
		b = getParent(b);
		if(a == b) return true;
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		parent = new int[n+1];
		for(int i = 0; i<=n; i++)
			parent[i] = i;
		for(int k = 0; k<m; k++) {
			st = new StringTokenizer(br.readLine());
			int command = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(command == 0)
				union(a, b);
			else {
				if(find(a, b)) bw.write("YES\n");
				else bw.write("NO\n");
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
