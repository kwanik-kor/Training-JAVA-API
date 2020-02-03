package baekjun.search;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class LIS12015 {
	static int N, dp[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		dp = new int[N];
		Arrays.fill(dp, 1000001);
		int lower_bound = 0;
		for(int i = 0; i<N; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(dp[lower_bound] < num) 
				dp[++lower_bound] = num;
			else {
				int left = 0;
				int right = lower_bound;
				int mid = 0;
				while(left < right) {
					mid = (left + right)/2;
					if(dp[mid] < num)
						left = mid + 1;
					else
						right = mid;
				}
				dp[right] = num;
			}
		}
		bw.write(lower_bound + 1  + "");
		bw.flush();
		bw.close();
		br.close();
		
	}

}
