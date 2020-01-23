package baekjun.sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Treasure1026 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] a = new int[N];
		Integer[] b = new Integer[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++)
			a[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++)
			b[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(a);
		Arrays.sort(b, Collections.reverseOrder());
		
		int sum = 0;
		for(int i = 0; i<N; i++) {
			sum += a[i]*b[i];
		}
		
		bw.write(String.valueOf(sum));
		bw.flush();
		br.close();
		bw.close();
	}

}
