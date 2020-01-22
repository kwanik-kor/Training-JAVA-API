package baekjun.dfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class CountOfConnection {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int sum = 0;
		for(int i = 0; i<5; i++) {
			int n = Integer.parseInt(br.readLine());
			sum += (n<40)? 40 : n;
		}
		bw.write(String.valueOf(sum/5));
		bw.flush();
		bw.close();
		br.close();
	}

}
