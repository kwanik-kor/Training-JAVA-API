package baekjun.math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Pentagon1964 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int sum = 5;
		for(int i = 2; i<=N; i++) {
			sum = (sum + 3*i + 1)%45678;
		}
		bw.write(sum + "");
		bw.flush();
		bw.close();
		br.close();
	}

}
