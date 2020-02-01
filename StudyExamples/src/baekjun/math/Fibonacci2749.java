package baekjun.math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Fibonacci2749 {
	static long N, M = 1000000;
	static long dp[];
	
	static long pisano() {
		//피사노 주기 구하기
		long result = 0;
		//1. 공식 활용: k(10^m) = 15*(10^(m-1))
//		result = (long)(15 * Math.pow(10, 5));
		//2. 피사노 주기 직접 구하기
		long m1 = 0, m2 = 1;
		do {
			long temp = m1;
			m1 = m2;
			m2 = (temp + m2)%M;
			result++;
		}while(!(m1 == 0 && m2 == 1));
		
		return result;
	}
	
	static void dp() {
		if(N >= 0) dp[0] = 0;
		if(N >= 1) dp[1] = 1;
		for(int i = 2; i<dp.length; i++)
			dp[i] = (dp[i-1] + dp[i-2])%M;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		long P = pisano();
		N = Long.parseLong(br.readLine())%P;
		dp = new long[(int)P];
		dp();
		bw.write(dp[(int)N] + "");
		bw.flush();
		bw.close();
		br.close();
	}

}
