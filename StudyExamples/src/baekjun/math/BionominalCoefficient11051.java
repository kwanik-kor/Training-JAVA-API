package baekjun.math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BionominalCoefficient11051 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int arr[][] = new int[1001][1001];
		arr[0][0] = arr[1][0] = arr[1][1] = 1;
		for(int i = 2; i<=N; i++) {
			for(int j = 0; j<=i; j++) {
				if(i == j || j == 0) arr[i][j] = 1;
				else
					arr[i][j] = arr[i-1][j] + arr[i-1][j-1];
				arr[i][j] %= 10007;
			}
		}
		
		bw.write(String.valueOf(arr[N][K]));
		bw.flush();
		bw.close();
		br.close();
	}
	
}
