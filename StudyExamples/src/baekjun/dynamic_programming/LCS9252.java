package baekjun.dynamic_programming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class LCS9252 {
	static int dp[][];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String a = br.readLine();
		String b = br.readLine();
		dp = new int[a.length()+1][b.length()+1];
		for(int i = 1; i<=a.length(); i++) {
			for(int j = 1; j<=b.length(); j++) {
				if(a.charAt(i-1) == b.charAt(j-1))
					dp[i][j] = dp[i-1][j-1] + 1;
				else
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
			}
		}
		int result = dp[a.length()][b.length()];
		bw.write(result + "\n");
		
		int x = a.length();
		int y = b.length();
		Stack<Integer> stack = new Stack<>();
		while(dp[x][y] != 0) {
			if(dp[x-1][y] == result) {
				x--;
				continue;
			}
			if(dp[x][y-1] == result) {
				y--;
				continue;
			}
			stack.push(x);
			x--;
			y--;
			result--;
		}
		while(!stack.isEmpty())
			bw.write(a.charAt(stack.pop()-1) + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
