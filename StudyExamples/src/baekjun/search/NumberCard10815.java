package baekjun.search;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NumberCard10815 {
	static int N, M;
	static int arr[];
	
	static int binarySearch(int left, int right, int n) {
		int result = 0;
		while(left <= right) {
			int middle = (left + right)/2;
			if(n == arr[middle]) {
				result = 1;
				break;
			}else if(n > arr[middle])
				left = middle + 1;
			else if(n < arr[middle])
				right = middle - 1;
		}
		return result;
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
			bw.write(binarySearch(0, N-1, n) + " ");
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
