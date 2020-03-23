package baekjun.dynamic_programming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class LDS11722 {
	static int N;
	static int arr[];
	static int cache[];
	
	static int lds(int start) {
		if(cache[start] != -1)
			return cache[start];
		cache[start] = 1;
		for(int i = start + 1; i<N; i++)
			if(arr[start] > arr[i])
				cache[start] = Math.max(cache[start], lds(i) + 1);
		return cache[start];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[N];
		cache = new int[N];
		Arrays.fill(cache, -1);
		for(int i = 0; i<N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		int maxLen = 1;
		for(int i = 0; i<N; i++)
			maxLen = Math.max(maxLen, lds(i));
		bw.write(maxLen + "");
		bw.flush();
		bw.close();
		br.close();
	}

}
