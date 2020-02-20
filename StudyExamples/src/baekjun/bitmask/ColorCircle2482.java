package baekjun.bitmask;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ColorCircle2482 {
	static int N, K, dp[][];
	static final int div = 1000000003;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		
		bw.flush();
		bw.close();
		br.close();
	}

}
