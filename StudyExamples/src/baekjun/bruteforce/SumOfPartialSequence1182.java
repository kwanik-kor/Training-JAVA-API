package baekjun.bruteforce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SumOfPartialSequence1182 {
	static int cnt = 0;
	static int S;
	
	static void calc(int[] arr, int n, int idx, int sum) {
		if(idx == n) {
			if(sum == S)
				cnt++;
			return;
		}
		calc(arr, n, idx+1, sum);
		calc(arr, n, idx+1, sum + arr[idx]);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		int arr[] = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		calc(arr, N, 0, 0);
		
		if(S==0) cnt--;
		
		bw.write(cnt+"");
		bw.flush();
		bw.close();
		br.close();
	}

}
