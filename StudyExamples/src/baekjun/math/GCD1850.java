package baekjun.math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class GCD1850 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());
		long result = (a>=b)? gcd(a, b): gcd(b, a);
		for(int i = 0; i<result; i++) {
			bw.write("1");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	static long gcd(long a, long b) {
		return (a%b == 0)? b : gcd(b, a%b);
	}
}
