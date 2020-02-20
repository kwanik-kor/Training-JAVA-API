package baekjun.disjoint_set;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class LetsTravel1976 {
	static int N, M;
	static int parent[];
	static StringTokenizer st;
	
	static void union(int a, int b) {
		int a2 = getParent(a);
		int b2 = getParent(b);
		if(a2 <= b2)
			parent[b2] = parent[a2];
		else
			parent[a2] = parent[b2];
	}
	
	static int getParent(int node) {
		if(parent[node] == node)
			return node;
		else
			return parent[node] = getParent(parent[node]);
	}
	
	static int find(int a, int b) {
		a = getParent(a);
		b = getParent(b);
		if(a == b) return 1;
		else return 0;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		parent = new int[N+1];
		for(int i = 1; i<=N; i++)
			parent[i] = i;
		for(int i = 1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j<=N; j++) {
				if(Integer.parseInt(st.nextToken()) == 1)
					union(i, j);
			}
		}
		int city[] = new int[M];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<M; i++)
			city[i] = Integer.parseInt(st.nextToken());
		
		boolean flag = true;
		for(int i = 0; i<M-1; i++) {
			/*if(find(city[i], city[i+1]) == 0) {
				flag = false;
				break;
			}*/
			if(parent[city[i]] != parent[city[i+1]]) {
				flag = false;
				break;
			}
		}
		if(flag)
			bw.write("YES");
		else
			bw.write("NO");
		bw.flush();
		br.close();
		bw.close();
	}

}
