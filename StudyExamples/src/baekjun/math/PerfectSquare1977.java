package baekjun.math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class PerfectSquare1977 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int M = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer> square = new ArrayList<>();
		int total = 0;
		for(int i = M; i<=N; i++) {
			if(i == Math.pow((int)Math.sqrt(i), 2)) {
				square.add(i);
				total += i;
			}
		}
		if(total == 0) bw.write("-1");
		else bw.write(total + "\n" + square.get(0));
		bw.flush();
		bw.close();
		br.close();
	}

}
