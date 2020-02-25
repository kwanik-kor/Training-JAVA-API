package baekjun.tree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class TreeCircuit2263 {
	static int N, in[], post[], order[];
	static StringBuilder sb = new StringBuilder("");
	
	static void preOrder(int in_start, int in_end, int post_start, int post_end) {
		if(in_end < in_start || post_end < post_start) return;
		int root = post[post_end];
		sb.append(root + " ");
		int root_idx = order[root];
		int left = root_idx - in_start;
		preOrder(in_start, root_idx - 1, post_start, post_start + left - 1);
		preOrder(root_idx + 1, in_end, post_start + left, post_end - 1);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		in = new int[N+1];
		post = new int[N+1];
		order = new int[N+1];
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for(int i = 1; i<=N; i++) {
			in[i] = Integer.parseInt(st1.nextToken());
			post[i] = Integer.parseInt(st2.nextToken());
			order[in[i]] = i;
		}
		preOrder(1, N, 1, N);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}
