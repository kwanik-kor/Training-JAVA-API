package baekjun.dynamic_programming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Padovan9461 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		long arr[] = new long[101];
		arr[1] = arr[2] = arr[3] = 1;
		arr[4] = arr[5] = 2;
		for(int i = 0; i<T; i++) {
			int N = Integer.parseInt(br.readLine());
			if(arr[N] > 0)
				bw.write(arr[N] + "\n");
			else {
				for(int j = 6; j <= N; j++) {
					arr[j] = arr[j-5] + arr[j-1];
				}
				bw.write(arr[N] + "\n");
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
