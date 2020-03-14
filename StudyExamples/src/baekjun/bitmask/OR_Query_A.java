package baekjun.bitmask;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class OR_Query_A {
	static int N, K, M;
	static int arr[][];
	static StringTokenizer st;
	
	static void query_one(int l, int r, int x) {
		for(int i = l; i<=r; i++) {
			arr[i][0] |= x;
			if(arr[i][0] == K) {
				for(int j = i; j<=N; j++)
					arr[j][1]++;
			}
		}
	}
	
	static int query_two(int l , int r) {
		return arr[r][1] - arr[l-1][1];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N+1][2];
		
		//Fill Array
		st = new StringTokenizer(br.readLine());
		int cnt = 0;
		for(int i = 1; i<=N; i++) {
			arr[i][0] = Integer.parseInt(st.nextToken());
			if(arr[i][0] == K) arr[i][1] = ++cnt;
			else arr[i][1] = cnt;
		}
		
		//Query
		M = Integer.parseInt(br.readLine());
		for(int m = 0; m<M; m++) {
			st = new StringTokenizer(br.readLine());
			int query = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			if(query == 1) query_one(l, r, Integer.parseInt(st.nextToken()));
			else bw.write(query_two(l, r) + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
