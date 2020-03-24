package jonman.dynamic_programming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Numb3rs {
	static int N, D, P, T, q;
	static double[][] dp = new double[51][101];
	static int[] connectCnt = new int[51];
	static int[][] map = new int[51][51];
	static StringTokenizer st;
	
	static double solve(int pos, int day) {
		if(day == D) 
			return (pos == q)? 1.0 : 0.0;
		if(dp[pos][day] > -0.5)
			return dp[pos][day];
		dp[pos][day] = 0.0;
		for(int there = 0; there < N; there++) {
			if(map[pos][there] == 1)
				dp[pos][day] += solve(there, day + 1)/connectCnt[pos];
		}
		
		return dp[pos][day];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCase = Integer.parseInt(br.readLine());
		for(int t = 0; t<testCase; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			D = Integer.parseInt(st.nextToken());
			P = Integer.parseInt(st.nextToken());
			//산길 입력
			for(int i = 0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				connectCnt[i] = 0;
				for(int j = 0; j<N; j++){
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] == 1)
						connectCnt[i]++;
				}
			}
			
			//확률 계산 마을
			T = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i<T; i++) {
				q = Integer.parseInt(st.nextToken());
				for(int j = 0; j<N; j++)
					Arrays.fill(dp[j], -0.5);
				bw.write(String.format("%.4f", solve(P, 0)) + " ");
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
