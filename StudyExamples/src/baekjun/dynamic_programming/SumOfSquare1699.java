package baekjun.dynamic_programming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SumOfSquare1699 {
	static int[] cache;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		cache = new int[N+1];
		for(int i = 1; i<=N; i++) 
			cache[i] = i;
		for(int i = 2; i<=N; i++) {
			for(int j = 2; j*j<=i; j++)
				cache[i] = Math.min(cache[i], cache[i - j*j] + 1);
		}
		bw.write(cache[N] + "");
		bw.flush();
		bw.close();
		br.close();
	}

}
