package baekjun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SelectClass {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static int calc(int total, int n) throws IOException {
		int min = Integer.MAX_VALUE;
		for(int i = 0; i<n; i++) {
			int score = Integer.parseInt(br.readLine());
			total += score;
			min = Math.min(min, score);
		}
		total -= min;
		return total;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int total = 0;
		total = calc(total, 4);
		total = calc(total, 2);
		bw.write(total + "");
		bw.flush();
		bw.close();
		br.close();
	}

}
