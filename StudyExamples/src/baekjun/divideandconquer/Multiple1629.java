package baekjun.divideandconquer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Multiple1629 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		bw.write(pow(A, B, C) + "");
		bw.flush();
		bw.close();
		br.close();
	}
	
	static long pow(int a, int b, int c) {
		if(b == 0) return 1;
		long n = pow(a, b/2, c);
		long temp = n*n % c;
		if(b%2 == 0)
			return temp;
		else
			return temp * a % c;
	}

}
