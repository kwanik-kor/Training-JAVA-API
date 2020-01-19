package baekjun.math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Factorial0Count1676 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int cnt2 = 0; 
		int cnt5 = 0;
		for(int i = 2; i<=N; i *= 2) {
			cnt2 += N/i;
		}
		for(int i = 5; i<=N; i *= 5) {
			cnt5 += N/i;
		}
		
		bw.write(String.valueOf(Math.min(cnt2, cnt5)));
		bw.flush();
		br.close();
		bw.close();
	}

}
