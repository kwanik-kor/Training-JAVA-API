package baekjun.tree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class ParentOfTree11725 {
	static int N;
	static int parents[];
	static LinkedList<Integer> list[];
	static StringTokenizer st;
	
	static void bfs(int start) {
		LinkedList<Integer> queue = new LinkedList<>();
		queue.offer(start);
		while(!queue.isEmpty()) {
			int parent = queue.poll();
			for(int item : list[parent]) {
				if(parents[item] == 0) {
					parents[item] = parent;
					queue.offer(item);
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		list = new LinkedList[N+1];
		parents = new int[N+1];
		for(int i = 1; i<=N; i++)
			list[i] = new LinkedList<>();
		for(int i = 0; i<N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		bfs(1);
		for(int i = 2; i<=N; i++)
			bw.write(parents[i] + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

}
