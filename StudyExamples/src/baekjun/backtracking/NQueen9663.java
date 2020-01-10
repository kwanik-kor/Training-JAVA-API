package baekjun.backtracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class NQueen9663 {
	static int N;
	static int[] cols;
	static int result = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		cols = new int[N];
		backTracking(0);
		bw.write(String.valueOf(result));
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void backTracking(int cnt) {
		if(cnt == N) {
			result++;
			return;
		}
			
		for(int i = 0; i<N; i++) {
			cols[cnt] = i;
			if(isPossible(cnt))
				backTracking(cnt + 1);
		}
	}
	
	static boolean isPossible(int cnt) {
		for(int i = 0; i<cnt; i++) {
			if(cols[i]==cols[cnt] || Math.abs(cnt - i) == Math.abs(cols[cnt] - cols[i]))
				return false;
		}
		return true;
	}
}
