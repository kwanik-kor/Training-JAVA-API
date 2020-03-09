package baekjun.sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class MergeSort11728 {
	static int N, M;
	static int A[], B[], sorted[];
	
	static void merge() {
		int i = 0;
		int j = 0;
		int idx = 0;
		while(i<=N-1 && j <= M-1) {
			if(A[i] <= B[j]) {
				sorted[idx] = A[i];
				i++;
			}else {
				sorted[idx] = B[j];
				j++;
			}
			idx++;
		}
		if(i < N) {
			for(int t = i; t<N; t++) {
				sorted[idx] = A[t];
				idx++;
			}
		}else {
			for(int t = j; t<M; t++) {
				sorted[idx] = B[t];
				idx++;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		A = new int[N];
		B = new int[M];
		sorted = new int[N+M];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++)
			A[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<M; i++)
			B[i] = Integer.parseInt(st.nextToken());
		merge();
		for(int i = 0; i<N+M; i++) {
			bw.write(sorted[i] + " ");
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
