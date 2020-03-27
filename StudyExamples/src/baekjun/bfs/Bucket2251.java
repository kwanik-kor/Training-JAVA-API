package baekjun.bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bucket2251 {
	static int[] arr = new int[3];
	static int[] from = {0, 0, 1, 1, 2, 2};
	static int[] to = {1, 2, 0, 2, 0, 1};
	static boolean[][] visit;
	static boolean[] c;
	
	static void bfs() {
		Queue<State> q = new LinkedList<>();
		q.add(new State(0, 0, arr[2]));
		visit[0][0] = true;
		c[arr[2]] = true;
		while(!q.isEmpty()) {
			State s = q.poll();
			for(int i = 0; i<6; i++) {
				int[] next = {s.a, s.b, s.c};
				next[to[i]] += next[from[i]];
				next[from[i]] = 0;
				if(next[to[i]] > arr[to[i]]) {
					next[from[i]] = next[to[i]] - arr[to[i]];
					next[to[i]] = arr[to[i]];
				}
				if(!visit[next[0]][next[1]]) {
					visit[next[0]][next[1]] = true;
					q.add(new State(next[0], next[1], next[2]));
					if(next[0] == 0)
						c[next[2]] = true;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<3; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		visit = new boolean[arr[0] + 1][arr[1] + 1];
		c = new boolean[arr[2] + 1];
		bfs();
		for(int i = 0; i<=arr[2]; i++)
			if(c[i])
				bw.write(i + " ");
		bw.flush();
		bw.close();
		br.close();
	}
	
	static class State{
		int a;
		int b;
		int c;
		public State(int a, int b, int c) {
			this.a = a;
			this.b = b;
			this.c = c;
		}
	}
}
