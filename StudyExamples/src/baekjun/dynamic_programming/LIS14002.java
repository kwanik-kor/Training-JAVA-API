package baekjun.dynamic_programming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class LIS14002 {
	static int N;
	static int A[], dp[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		A = new int[N];
		dp = new int[N][2];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++)
			A[i] = Integer.parseInt(st.nextToken());
		int max = 1;
		int idx = 0;
		dp[0][0] = 1;
		for(int i = 1; i<N; i++) {
			dp[i][0] = 1;
			for(int j = 0; j<i; j++) {
				if(A[i] > A[j] && dp[i][0] <= dp[j][0]) {
					dp[i][0] = dp[j][0] + 1;
					dp[i][1] = j;
				}
				if(A[i] == A[j]) {
					dp[i][0] = dp[j][0];
					dp[i][1] = j;
				}
			}
			if(dp[i][0] > max) {
				max = dp[i][0];
				idx = i;
			}
			
		}
		bw.write(max + "\n");
	
		Stack<Integer> stack = new Stack<>();
		stack.push(A[idx]);
		while(stack.size() != max) {
			stack.push(A[dp[idx][1]]);
			idx = dp[idx][1];
		}
		while(!stack.isEmpty())
			bw.write(stack.pop() + " ");
		bw.flush();
		bw.close();
		br.close();
	}

}
