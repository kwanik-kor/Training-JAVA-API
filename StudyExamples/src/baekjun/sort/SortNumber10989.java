package baekjun.sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SortNumber10989 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[10001];
		for(int i = 0; i<N; i++) {
			arr[Integer.parseInt(br.readLine())]++;
		}
		for(int i = 0; i<arr.length; i++) {
			for(int j = 0; j<arr[i]; j++) {
				bw.write(i + "\n");
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
