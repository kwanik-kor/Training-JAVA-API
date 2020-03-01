package baekjun.math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SumFraction1735 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int C = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		
		int y = B*D;
		int x = A*D + C*B;
		int gcd = gcd(Math.min(x, y), Math.max(x, y));
		bw.write(x/gcd + " " + y/gcd);
		bw.flush();
		bw.close();
		br.close();
	}
	
	static int gcd(int a, int b) {
		return (a%b == 0)? b : gcd(b, a%b);
	}
}
