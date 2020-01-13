package baekjun.dynamic_programming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Fibonacci1003 {
	static int arr[][] = new int[41][2];
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static void fibo1(int N) throws IOException {
		arr[0][0] = 1;
		arr[1][1] = 1;
		for(int i = 2; i<41; i++) {
			for(int j = 0; j<2; j++) {
				arr[i][j] = arr[i-1][j] + arr[i-2][j];
			}
		}
		bw.write(arr[N][0] + " " + arr[N][1] + "\n");
	}
	
	static int fibo2(int N) {
		int a = 1;
		int b = 0;
		int c = 1;
		if(N == 0)
			return a;
		if(N == 1)
			return b;
		for(int i = 1; i<=N; i++) {
			a = b;
			b = c;
			c = a+b;
		}
		return a;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int i = 0; i<T; i++) {
			int N = Integer.parseInt(br.readLine());
//			fibo1(N);
			bw.write(fibo2(N) + " " + fibo2(N+1) + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
