package baekjun.backtracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MultipleOfThree16561 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int result = 0;
		int sum = 0;
		for(int i = 1; i<=N/3; i++) {
			for(int j = 1; j<=N/3; j++) {
				sum = i*3 + j*3;
				if((N-sum) % 3 == 0 && sum < N)
					result++;
			}
		}
		bw.write(result + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
