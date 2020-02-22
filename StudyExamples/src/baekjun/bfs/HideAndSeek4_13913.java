package baekjun.bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class HideAndSeek4_13913 {
	static int N, K;
	static int result[][] = new int[100001][2];
	static boolean visited[] = new boolean[100001];
	static int x[];
	static StringTokenizer st;
	
	static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		while(!q.isEmpty()) {
			int n = q.poll();
			if(n == K) break;
			x = new int[3];
			x[0] = n - 1;
			x[1] = n + 1;
			x[2] = n*2;
			for(int i = 0; i<3; i++) {
				if(x[i] >= 0 && x[i] <= 100000 && !visited[x[i]]) {
					q.add(x[i]);
					visited[x[i]] = true;
					result[x[i]][0] = result[n][0] + 1;
					result[x[i]][1] = n;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		bfs(N);
		int ans = result[K][0];
		bw.write(ans + "\n");
		
		Stack<Integer> stack = new Stack<>();
		int temp = K;
		while(stack.size() != ans) {
			stack.push(temp = result[temp][1]);
		}
		while(!stack.isEmpty())
			bw.write(stack.pop() + " ");
		bw.write(K + "");
		
		bw.flush();
		bw.close();
		br.close();
	}

}
