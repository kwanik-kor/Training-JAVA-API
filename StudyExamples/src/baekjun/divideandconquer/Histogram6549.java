package baekjun.divideandconquer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Histogram6549 {
	static int N;
	static long histo[];
	
	static long solve(int left, int right) {
		if(left == right) return histo[left];
		int mid = (left + right)/2;
		long ret = Math.max(solve(left, mid), solve(mid + 1, right));
		
		int low = mid;
		int high = mid + 1;
		long height = Math.min(histo[low], histo[high]);
		ret = Math.max(ret, height * 2);
		while(left < low || high < right) {
			if(high < right && (low == left || histo[low-1] < histo[high + 1])) {
				high++;
				height = Math.min(height, histo[high]);
			}
			else {
				low--;
				height = Math.min(height, histo[low]);
			}
			ret = Math.max(ret, height * (high - low + 1));
		}
		return ret;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String s;
		while(!(s = br.readLine()).equals("0")) {
			StringTokenizer st = new StringTokenizer(s);
			N = Integer.parseInt(st.nextToken());
			histo = new long[N+1];
			for(int i = 1; i<=N; i++)
				histo[i] = Long.parseLong(st.nextToken());
			bw.write(solve(1, N) + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
