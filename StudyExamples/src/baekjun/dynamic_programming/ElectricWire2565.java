package baekjun.dynamic_programming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

public class ElectricWire2565 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		String arr[] = new String[N];
		for(int i = 0; i<N; i++) {
			arr[i] = br.readLine();
		}
		Arrays.sort(arr, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				int a = Integer.parseInt(o1.split(" ")[0]);
				int b = Integer.parseInt(o2.split(" ")[0]);
				return a-b;
			}
		});
		int[] B = new int[N];
		int[] dp = new int[N];
		int max = 1;
		for(int i = 0; i<N; i++) {
			B[i] = Integer.parseInt(arr[i].split(" ")[1]);
			dp[i] = 1;
			for(int j = 0; j<i; j++) {
				if(B[i] >= B[j] && dp[i] < dp[j] + 1)
					dp[i] = dp[j] + 1;
			}
			if(dp[i] > max) max = dp[i];
		}
		
		bw.write(String.valueOf(N - max));
		bw.flush();
		bw.close();
		br.close();
	}

}
