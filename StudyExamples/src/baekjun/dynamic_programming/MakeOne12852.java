package baekjun.dynamic_programming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class MakeOne12852 {
	static int N;
	static int dp[][];
	
	static void calc(int n) {
		if(n == 1) return;
		if(n % 3 == 0) {
			if(dp[n/3][0] >= dp[n][0] + 1) {
				dp[n/3][0] = dp[n][0] + 1;
				dp[n/3][1] = n;
				calc(n/3);
			}
		}
		if(n % 2 == 0) {
			if(dp[n/2][0] >= dp[n][0] + 1) {
				dp[n/2][0] = dp[n][0] + 1;
				dp[n/2][1] = n;
				calc(n/2);
			}
		}
		if(dp[n-1][0] >= dp[n][0] + 1) {
			dp[n-1][0] = dp[n][0] + 1;
			dp[n-1][1] = n;
			calc(n-1);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		dp = new int[N+1][2];
		for(int i = 0; i<=N; i++) 
			dp[i][0] = Integer.MAX_VALUE;
		dp[N][0] = 0;
		calc(N);
		bw.write(dp[1][0] + "\n");
		if(N == 2) 
			bw.write("2 ");
		else {
			int reverse = 1;
			Stack<Integer> stack = new Stack<>();
			while(stack.size() != dp[1][0])
				stack.push(reverse = dp[reverse][1]);
			while(!stack.isEmpty())
				bw.write(stack.pop() + " ");
		}
		bw.write("1");
		bw.flush();
		bw.close();
		br.close();
	}

}
