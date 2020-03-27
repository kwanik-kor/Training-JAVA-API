package baekjun.bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class StoneBridge12761 {
	static int A, B, M;
	static int d1[] = new int[6];
	static int d2[] = new int[2];
	static int[] arr = new int[100001];
	
	static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		arr[start] = 1;
		while(!q.isEmpty()) {
			int now = q.poll();
			for(int i = 0; i<6; i++) {
				int next = now + d1[i];
				if(next < 0 || next > 100000 || arr[next] != 0) continue;
				arr[next] = arr[now] + 1;
				q.add(next);
			}
			for(int i = 0; i<2; i++) {
				int next = now * d2[i];
				if(next < 0 || next > 100000 || arr[next] != 0) continue;
				arr[next] = arr[now] + 1;
				q.add(next);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		d1[0] = 1; d1[1] = -1; d1[2] = A; d1[3] = -A; d1[4] = B; d1[5] = -B;
		d2[0] = A; d2[1] = B;
		bfs(N);
		bw.write(arr[M] - 1 + "");
		bw.flush();
		bw.close();
		br.close();
	}

}
