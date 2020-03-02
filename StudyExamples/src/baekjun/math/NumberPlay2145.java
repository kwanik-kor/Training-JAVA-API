package baekjun.math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class NumberPlay2145 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n;
		while((n = Integer.parseInt(br.readLine())) != 0) {
			while(n/10 > 0) {
				n = calc(n);
			}
			bw.write(n + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	static int calc(int n) {
		int sum = 0;
		while(n > 0) {
			sum += n % 10;
			n /= 10;
		}
		return sum;
	}
}
