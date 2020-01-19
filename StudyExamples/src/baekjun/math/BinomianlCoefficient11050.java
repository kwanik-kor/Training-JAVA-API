package baekjun.math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BinomianlCoefficient11050 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		M = (N-M < M)? N-M : M;
		int top = 1;
		int bottom = 1;
		for(int i = N; i>N-M; i--) {
			top *= i;
		}
		for(int i = 2; i<=M; i++) {
			bottom *= i;
		}
		bw.write(String.valueOf(top/bottom));
		bw.flush();
		bw.close();
		br.close();
	}

}
