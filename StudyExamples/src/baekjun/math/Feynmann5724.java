package baekjun.math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Feynmann5724 {
	static int dp[] = new int[101];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String s = "";
		for(int i = 1; i<=100; i++)
			dp[i] = dp[i-1] + i*i;
		while(!(s = br.readLine()).equals("0")) {
			bw.write(dp[Integer.parseInt(s)] + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
