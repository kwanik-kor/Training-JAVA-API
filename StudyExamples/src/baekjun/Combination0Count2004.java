package baekjun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Combination0Count2004 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long n = Long.parseLong(st.nextToken());
		long m = Long.parseLong(st.nextToken());
		long result2 = countZero2(n) - (countZero2(m) + countZero2(n-m));
		long result5 = countZero5(n) - (countZero5(m) + countZero5(n-m));
		bw.write(String.valueOf(Math.min(result2, result5)));
		bw.flush();
		bw.close();
		br.close();
	}
	
	static long countZero5(long n) {
		long cnt5 = 0;
		for(long i = 5; i<=n; i *= 5)
			cnt5 += n/i;
		return cnt5;
	}
	
	static long countZero2(long n) {
		long cnt2 = 0;
		for(long i = 2; i<=n; i *= 2)
			cnt2 += n/i;
		return cnt2;
	}
}
