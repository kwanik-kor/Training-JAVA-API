package baekjun.math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Sosu1929 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		boolean[] arr = new boolean[N+1];
		Arrays.fill(arr, false);
		arr[1] = true;
		for(int i = 2; i<=Math.sqrt(arr.length); i++) {
			for(int j = 2; i*j<arr.length; j++) {
				arr[i*j] = true;
			}
		}
		for(int i = M; i<=N; i++) {
			if(!arr[i])
				System.out.println(i);
		}
		br.close();
	}

}
