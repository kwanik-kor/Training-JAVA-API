package baekjun.divideandconquer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SquaredMatrix10830 {
	static int A[][], N;
	static long B;
	
	static int[][] divide(long b) {
		int ans[][] = new int[N][N];
		int temp[][] = new int[N][N];
		if(b == 1) {
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<N; j++)
					temp[i][j] = A[i][j] % 1000;
			}
			return temp;
		}else if(b % 2 == 0) {
			temp = divide(b/2);
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<N; j++) {
					for(int k = 0; k<N; k++) {
						ans[i][j] += temp[i][k]*temp[k][j];
					}
					ans[i][j] %= 1000;
				}
			}
			return ans;
		}else {
			temp = divide(b-1);
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<N; j++) {
					for(int k = 0; k<N; k++)
						ans[i][j] += temp[i][k]*A[k][j];
					ans[i][j] %= 1000;
				}
			}
			return ans;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		B = Long.parseLong(st.nextToken());
		A = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<N; j++)
				A[i][j] = Integer.parseInt(st.nextToken());
		}
		int result[][] = divide(B);
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++)
				bw.write(result[i][j] + " ");
			bw.write("\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
