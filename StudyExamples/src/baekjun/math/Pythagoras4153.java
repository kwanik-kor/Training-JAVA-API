package baekjun.math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Pythagoras4153 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		while(true) {
			String s = br.readLine();
			if(s.equals("0 0 0"))
				break;
			else {
				int[] arr = {Integer.parseInt(s.split(" ")[0]), Integer.parseInt(s.split(" ")[1]), Integer.parseInt(s.split(" ")[2])};
				Arrays.sort(arr);
				if(arr[2]*arr[2] == arr[0]*arr[0] + arr[1]*arr[1])
					bw.write("right\n");
				else
					bw.write("wrong\n");
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
