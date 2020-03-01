package baekjun.math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Jumong1940 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		boolean[] arr = new boolean[200001];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++)
			arr[Integer.parseInt(st.nextToken())] = true;
		int start = 1;
		int end = M-1;
		int cnt = 0;
		if(M >= 200000) bw.write("0");
		else {
			while(start < end) {
				if(arr[start] && arr[end] && start + end == M)
					cnt++;
				start++;
				end--;
			}
			bw.write(cnt+"");
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
