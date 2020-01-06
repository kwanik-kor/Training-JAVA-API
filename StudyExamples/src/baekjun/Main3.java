package baekjun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main3 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] arr = bf.readLine().split(" ");
		int f = Integer.parseInt(arr[0]);
		int v = Integer.parseInt(arr[1]);
		int p = Integer.parseInt(arr[2]);
		if(v >= p) {
			bw.write(Integer.toString(-1));
		}else {
			bw.write(Integer.toString(f/(p-v) + 1));
		}
		bw.flush();
		bw.close();
	}
}
