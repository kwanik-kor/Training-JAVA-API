package baekjun.dynamic_programming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class StairNumber10844 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		long dp[][] = new long[100][9];
		int total = 0;
		for(int i = 0; i<9; i++) {
			dp[0][i] = 1;
			if(i == 8)
				dp[1][i] = 1;
			else
				dp[1][i] = 2;
		}
		if(N>2) {
			for(int i = 2; i<N; i++) {
				for(int j = 0; j<9; j++) {
					if(j == 0) 
						dp[i][j] = (dp[i-2][j] + dp[i-1][j+1]) % 1000000000;
					else if(j == 8)
						dp[i][j] = dp[i-1][j-1] % 1000000000;
					else
						dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % 1000000000;
				}
			}
		}
		
		for(int i = 0; i<9; i++) {
			total += dp[N-1][i];
		}
		bw.write(String.valueOf(total % 1000000000));
		bw.close();
		br.close();
	}

}
