package baekjun.divideandconquer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class MatrixMultiple2740 {
	static int matrixA[][], matrixB[][], result[][];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		matrixA = new int[N][M];
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<M; j++)
				matrixA[i][j] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		st.nextToken();
		int K = Integer.parseInt(st.nextToken());
		matrixB = new int[M][K];
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<K; j++)
				matrixB[i][j] = Integer.parseInt(st.nextToken());
		}
		
		result = new int[N][K];
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<K; j++) {
				int sum = 0;
				for(int k = 0; k<M; k++) {
					sum += matrixA[i][k]*matrixB[k][j];
				}
				result[i][j] = sum;
			}
		}
		
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<K; j++)
				bw.write(result[i][j] + " ");
			bw.write("\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
