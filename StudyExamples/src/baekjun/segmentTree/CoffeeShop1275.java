package baekjun.segmentTree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class CoffeeShop1275 {
	static int N, Q;
	static int arr[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		arr = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i<=N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		for(int q = 0; q<Q; q++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int sum = 0;
			for(int i = Math.min(x, y); i<= Math.max(x, y); i++)
				sum += arr[i];
			arr[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
			bw.write(sum + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
