package baekjun.bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ZeroOneTwo8112 {
	static int MAX = 20001;
	static int N;
	static Node arr[] = new Node[MAX];
	static boolean[] visit = new boolean[MAX];
	
	static void bfs() {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(1);
		visit[1] = true;
		arr[1].x = -1;
		arr[1].c = '1';
		while(!q.isEmpty()) {
			int now = q.poll();
			int p[] = new int[2];
			p[0] = (now*10) % N;
			p[1] = (p[0] + 1) % N;
			for(int i = 0; i<2; i++) {
				if(!visit[p[i]]) {
					arr[p[i]].x = now;
					arr[p[i]].c = (char) (i + '0');
					if(p[i] == 0)
						return;
					visit[p[i]] = true;
					q.add(p[i]);
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			N = Integer.parseInt(br.readLine());
			if(N == 1) {
				bw.write("1\n");
				continue;
			}
			Arrays.fill(visit, false);
			bfs();
			
		}
	}
	
	static class Node{
		int x;
		char c;
		public Node(int x, char c) {
			this.x = x;
			this.c = c;
		}
	}
}
