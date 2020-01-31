package baekjun.search;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class LANLine1654 {
	static long[] LAN;
	static long left = 1, right = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		LAN = new long[K];
		for(int k = 0; k < K; k++) {
			LAN[k] = Long.parseLong(br.readLine());
			right = Math.max(right, LAN[k]);
		}
		while(left <= right) {
			long mid = (left + right)/2;
			long cnt = 0;
			for(int i = 0; i<K; i++) {
				cnt += LAN[i]/mid;
			}
			if(cnt < N)
				right = mid - 1;
			else 
				left = mid + 1;
		}
		bw.write(right + "");
		bw.flush();
		bw.close();
		br.close();
	}

}
