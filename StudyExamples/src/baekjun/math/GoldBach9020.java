package baekjun.math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class GoldBach9020 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		boolean[] arr = new boolean[10001];
		Arrays.fill(arr, false);
		arr[1] = true;
		for(int i = 2; i <= Math.sqrt(arr.length); i++) {
			for(int j = 2; i*j < arr.length; j++) {
				arr[i*j] = true;
			}
		}
		for(int i = 0; i<T; i++) {
			int n = Integer.parseInt(br.readLine());
			int c = n/2;
			int min = 0;
			int max = 0;
			for(int j = 0; j<c; j++) {
				if(!arr[c-j] && !arr[c+j]) {
					min = c-j;
					max = c+j;
					break;
				}
			}
			bw.write(min + " " + max + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
