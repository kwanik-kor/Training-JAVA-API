package baekjun.search;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Felling2805 {
	static int N;
	static long M, arr[];
	
	static long binary(long left, long right) {
		while(left <= right) {
			long mid = (left + right)/2;
			long sum = 0;
			for(int i =0; i<N; i++) {
				if(arr[i]>mid) sum+=arr[i]-mid;
			}
			if(sum >= M)
				left = mid + 1;
			else
				right = mid - 1;
		}
		return right;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Long.parseLong(st.nextToken());
		arr = new long[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(arr);
		bw.write(binary(0, 2000000000)+"");
		bw.flush();
		bw.close();
		br.close();
	}

}
