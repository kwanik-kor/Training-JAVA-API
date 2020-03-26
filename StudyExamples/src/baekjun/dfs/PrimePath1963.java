package baekjun.dfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class PrimePath1963 {
	static int start, end;
	static int[] d = {1000, 100, 10, 1};
	static boolean[] prime = new boolean[10000];
	static int[] visit = new int[10000];
	static final String IMPOSSIBLE = "Impossible\n";
	
	static void aratos() {
		Arrays.fill(prime, true);
		for(int i = 2; i <= (int)Math.sqrt(10000); i++) {
			if(prime[i]) {
				for(int j = i*i; j<10000; j += i)
					prime[j] = false;
			}
		}
	}
	
	static void bfs() {
		for(int i = 1000; i<10000; i++)
			visit[i] = 0;
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(start);
		visit[start] = 1;
		
		while(!q.isEmpty()) {
			if(q.peek() == end) break;
			int num = q.poll();
			int[] n = new int[4];
			int tmp = num;
			for(int i = 0; i<4; i++) {
				n[3-i] = tmp%10;
				tmp /= 10;
			}
			
			for(int i = 0; i<4; i++) {
				for(int j = 0; j<10; j++) {
					n[i] = (n[i] + 1)%10;
					int next = 0;
					for(int k = 0; k<4; k++)
						next += n[k]*d[k];
					if(next < 1000 || !prime[next] || visit[next] != 0) continue;
					
					visit[next] = visit[num] + 1;
					q.add(next);
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCase = Integer.parseInt(br.readLine());
		aratos();
		for(int t = 0; t<testCase; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			bfs();
			int ans = visit[end];
			bw.write((ans == 0)? IMPOSSIBLE : (ans - 1) + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
