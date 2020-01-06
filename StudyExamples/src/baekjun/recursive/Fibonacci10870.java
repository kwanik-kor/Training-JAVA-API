package baekjun.recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Fibonacci10870 {

	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		System.out.println(fibonacci(n));
	}
	static int fibonacci(int n) {
		if(n == 0)
			return 0;
		else if(n == 1)
			return 1;
		else
			return fibonacci(n-1) + fibonacci(n-2); 
	}
}
