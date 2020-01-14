package baekjun.dynamic_programming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class LIS11053 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		int dp[]= new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		int max = 1;
		dp[0] = 1;
		for(int i = 1; i<N; i++) {
			dp[i] = 1;
			for(int j = 0; j<i; j++) {
				if(arr[i] > arr[j] && dp[i] <= dp[j])
					dp[i] = dp[j]+1;
				if(arr[i] == arr[j])
					dp[i] = dp[j];
			}
			if(dp[i] > max) max = dp[i];
		}
			
		bw.write(String.valueOf(max));
		bw.flush();
		bw.close();
		br.close();
	}

}
