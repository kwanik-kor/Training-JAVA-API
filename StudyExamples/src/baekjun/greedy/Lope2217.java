package baekjun.greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Lope2217 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		long arr[] = new long[N];
		for(int i = 0; i<N; i++)
			arr[i] = Long.parseLong(br.readLine());
		Arrays.sort(arr);
		long max = 0;
		for(int i = N-1; i>=0; i--) {
			arr[i] = arr[i] * (N-i);
			if(max < arr[i]) max = arr[i];
		}
		bw.write(max + "");
		bw.flush();
		bw.close();
		br.close();
	}

}
