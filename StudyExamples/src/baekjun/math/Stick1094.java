package baekjun.math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Stick1094 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		int t = 64;
		while(N>0) {
			if(t>N) {
				t/=2;
				continue;
			}else {
				N -= t;
				cnt++;
			}
		}
		bw.write(cnt + "");
		bw.flush();
		bw.close();
		br.close();
	}

}
