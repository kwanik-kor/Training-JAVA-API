package baekjun.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Fibonacci2748 {
	static int N;
	static long memo[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		memo = new long[91];
		System.out.println(fibo(N));
	}
	
	static long fibo(int n) {
		if(n<=1) 
			return n;
		if(memo[n] > 0) 
			return memo[n];
		memo[n] = fibo(n-1) + fibo(n-2);
		return memo[n];
	}
}
