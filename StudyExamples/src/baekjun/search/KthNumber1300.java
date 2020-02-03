package baekjun.search;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class KthNumber1300 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		int left = 1;
		int right = (int)Math.min((long)N*N, (long)1000000000);
		int result = 0;
		while(left <= right) {
			int mid = (left + right)/2;
			int cnt = 0;
			for(int i = 1; i<=N; i++)
				cnt += Math.min(mid/i, N);
			
			if(cnt >= k) {
				result = mid;
				right = mid - 1;
			}else
				left = mid + 1;
		}
		bw.write(result + "");
		bw.flush();
		bw.close();
		br.close();
	}

}
