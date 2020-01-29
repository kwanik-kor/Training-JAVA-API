package baekjun.search;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NumberCard10816 {
	static int N, M;
	static int arr[];
	
	static int lowerBound(int left, int right, int n) {
		while(left < right) {
			int mid = (left + right)/2;
			if(arr[mid] >= n) {
				right = mid;
			}else left = mid + 1;
		}
		return right;
	}
	static int upperBound(int left, int right, int n) {
		while(left < right) {
			int mid = (left + right)/2;
			if(arr[mid] > n)
				right = mid;
			else left = mid + 1;
		}
		return right;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(arr);
		for(int i = 0; i<M; i++){
			int n = Integer.parseInt(st2.nextToken());
			int up = upperBound(0, N-1, n);
			if(up == N - 1 && arr[N-1] == n) up++;
			bw.write(up - lowerBound(0, N-1, n) + " ");
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
