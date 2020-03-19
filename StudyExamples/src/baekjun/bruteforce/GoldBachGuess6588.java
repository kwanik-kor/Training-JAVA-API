package baekjun.bruteforce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class GoldBachGuess6588 {
	static boolean prime[] = new boolean[1000001];

	static void eratos() {
		Arrays.fill(prime, true);
		prime[0] = prime[1] = false;
		for(int i = 2; i<=Math.sqrt(1000000); i++) {
			if(prime[i]) {
				for(int j = i*2; j<=1000000; j += i)
					prime[j] = false;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = -1;
		eratos();
		while((n = Integer.parseInt(br.readLine())) != 0) {
			int a = 0, b = 0;
			for(int i = 2; i<=n/2; i++) {
				if(prime[i] && prime[n-i]) {
					a = i;
					b = n-i;
					break;
				}
			}
			if(a == 0) bw.write("Goldbach's conjecture is wrong.\n");
			else bw.write(String.format("%d = %d + %d\n", n, a, b));
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
