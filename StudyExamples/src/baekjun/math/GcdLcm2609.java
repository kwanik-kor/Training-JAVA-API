package baekjun.math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class GcdLcm2609 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int gcd = (N >= M)? gcd(N, M) : gcd(M, N);
		bw.write(String.format("%d\n%d", gcd, N*M/gcd));
		bw.flush();
		bw.close();
		br.close();
	}
	
	static int gcd(int a, int b) {
		return (a % b == 0) ? b : gcd(b, a%b);
	}
}
