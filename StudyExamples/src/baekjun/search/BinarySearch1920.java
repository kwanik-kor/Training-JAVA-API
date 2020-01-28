package baekjun.search;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BinarySearch1920 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(arr);
		int M = Integer.parseInt(br.readLine());
		int search[] = new int[M];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<M; i++)
			search[i] = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i<M; i++) {
			int left = 0;
			int right = N-1;
			boolean chk = false;
			
			while(left <= right) {
				int mid = (left + right)/2;
				if(search[i] > arr[mid])
					left = mid + 1;
				else if(search[i] < arr[mid])
					right = mid - 1;
				else {
					chk = true;
					break;
				}
			}
			if(chk) bw.write(1 + "\n");
			else bw.write(0 + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
