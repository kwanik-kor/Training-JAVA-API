package baekjun.dynamic_programming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Bitonic11054 {

	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		int dp[] = new int[N];
		int dpr[] = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int max = 1;
		for(int i = 0; i<N; i++) {
			dp[i] = 1;
			for(int j = 0; j<i; j++) {
				if(arr[i] > arr[j] && dp[i] <= dp[j])
					dp[i] = dp[j] + 1;
				if(arr[i] == arr[j])
					dp[i] = dp[j];
			}
		}
		for(int i = N-1; i>=0; i--) {
			dpr[i] = 1;
			for(int j = N-1; j>=i; j--) {
				if(arr[i] > arr[j] && dpr[i] <= dpr[j])
					dpr[i] = dpr[j] + 1;
				if(arr[i] == arr[j])
					dpr[i] = dpr[j];
			}
		}
		for(int i = 0; i<N; i++) {
			if(dp[i] + dpr[i] > max)
				max = dp[i] + dpr[i];
		}
		
		bw.write(String.valueOf(max-1));
		bw.flush();
		bw.close();
		br.close();
	}

}
