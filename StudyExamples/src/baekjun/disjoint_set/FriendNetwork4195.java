package baekjun.disjoint_set;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class FriendNetwork4195 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder("");
	static int parent[], rel[];
	
	static int getParent(int node) {
		if(parent[node] == node) return node;
		return parent[node] = getParent(parent[node]);
	}
	
	static void union(int a, int b) {
		int parent1 = getParent(a);
		int parent2 = getParent(b);
		
		if(parent1 == parent2) {
			sb.append(rel[parent1]+"\n");
			return;
		}
		
		int min = Math.min(parent1, parent2);
		int max = Math.max(parent1, parent2);
		
		parent[max] = parent[min];
		rel[min] += rel[max];
		sb.append(rel[min]+"\n");
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCase = Integer.parseInt(br.readLine());
		for(int t = 0; t<testCase; t++) {
			int F = Integer.parseInt(br.readLine());
			parent = new int[200001];
			rel = new int[200001];
			for(int i = 1; i<200001; i++){
				parent[i] = i;
				rel[i] = 1;
			}
			HashMap<String, Integer> friends = new HashMap<>();
			int idx = 1;
			
			for(int k = 0; k<F; k++) {
				st = new StringTokenizer(br.readLine());
				String f1 = st.nextToken();
				String f2 = st.nextToken();
				if(!friends.containsKey(f1))
					friends.put(f1, idx++);
				if(!friends.containsKey(f2))
					friends.put(f2, idx++);
				
				int num1 = friends.get(f1);
				int num2 = friends.get(f2);
				union(num1, num2);
			}
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}
