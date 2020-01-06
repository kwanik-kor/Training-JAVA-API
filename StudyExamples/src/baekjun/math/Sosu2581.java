package baekjun.math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Sosu2581 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int M = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		int sum = 0;
		int min = 10001;
		for(int i = M; i<=N; i++) {
			boolean b = true;
			for(int j = 2; j<=Math.sqrt(i); j++) {
				if(i%j == 0)
					b = false;
			}
			if(b && i != 1) {
				sum += i;
				if(i<min)
					min = i;
			}
		}
		if(sum == 0)
			bw.write(String.valueOf(-1));
		else {
			bw.write(String.valueOf(sum) + "\n" + String.valueOf(min));
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
