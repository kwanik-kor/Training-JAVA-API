package baekjun.math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Plug2010 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int total = 0;
		for(int i = 0; i<N; i++) {
			int cnt = Integer.parseInt(br.readLine());
			if(total == 0) total += cnt;
			else total += cnt - 1;
		}
		bw.write(total + "");
		bw.flush();
		bw.close();
		br.close();
	}

}
