package baekjun.math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Uclid3053 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int r = Integer.parseInt(br.readLine());
		double u = Math.PI * r * r;
		double t = 2 * r * r;
		bw.write(String.valueOf(u) + "\n" + String.valueOf(t));
		bw.flush();
		bw.close();
		br.close();
	}
}
