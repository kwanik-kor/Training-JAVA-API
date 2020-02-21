package baekjun.disjoint_set;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Airport10775 {
	static int G, P;
	static int parent[] = new int[100001];
	
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		parent[a] = b;
	}
	
	static int find(int node) {
		if(parent[node] == node) return node;
		return parent[node] = find(parent[node]);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		G = Integer.parseInt(br.readLine());
		P = Integer.parseInt(br.readLine());
		int result = 0;
		for(int i = 1; i<=G; i++)
			parent[i] = i;
		for(int i = 0; i<P; i++) {
			int gi = Integer.parseInt(br.readLine());
			int docking = find(gi);
			if(docking != 0) {
				union(docking, docking-1);
				result++;
			}else break;
		}
		
		bw.write(result + "");
		bw.flush();
		bw.close();
		br.close();
	}

}
