package baekjun.search;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Router2110 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int arr[] = new int[N];
		for(int i = 0; i<N; i++)
			arr[i] = Integer.parseInt(br.readLine());
		Arrays.sort(arr);
		int left = 1; //간격의 최소
		int right = arr[N-1] - arr[0]; //간격의 최대
		int result = 0;
		
		while(left <= right) {
			int mid = (left+right)/2; //원하는 간격
			int start = arr[0];
			int cnt = 1;
			
			for(int i = 1; i<N; i++) {
				int dis = arr[i] - start;
				if(dis >= mid) {
					cnt++;
					start = arr[i];
				}
			}
			
			if(cnt < C)
				right = mid - 1;
			else{
				left = mid + 1;
				result = mid;
			}
		}
		bw.write(result + "");
		bw.flush();
		bw.close();
		br.close();
	}

}
