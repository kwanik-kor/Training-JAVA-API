package baekjun.bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class HideAndSeek1697 {
	static int N, K;
	static int visited[] = new int[100001];
	static int x[];
	
	static int BFS(int a, int k, int result[]) {
		Queue<Integer> q = new LinkedList<>();
		q.add(a);
		result[a] = 0;
		
		while(!q.isEmpty() && a != K) {
			int n = q.poll();
			x = new int[3];
			x[0] = n - 1;
			x[1] = n + 1;
			x[2] = n * 2;
			for(int i = 0; i<3; i++) {
				if(x[i] >= 0 && x[i] <= 100000 && visited[x[i]] == 0) {
					q.add(x[i]);
					visited[x[i]] = 1;
					result[x[i]] = result[n]+1;
				}
			}
		}
		return result[K];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int result[] = new int[100001];
		bw.write(String.valueOf(BFS(N, 1, result)));
		bw.flush();
		bw.close();
		br.close();
	}

}
