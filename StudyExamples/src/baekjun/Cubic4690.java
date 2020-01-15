package baekjun;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Cubic4690 {
	static StringBuilder sb = new StringBuilder();
	static int N=6;
	static int arr[] = new int[3];
	
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i = 3; i<=100; i++) {
			N = i;
			backTracking(0);
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	static void backTracking(int cnt) {
		if(cnt == 3) {
			int sum = 0;
			for(int i = 0; i<3; i++)
				sum += arr[i] * arr[i] * arr[i];
			if(sum == (N*N*N))
				sb.append(String.format("Cube = %d, Triple = (%d,%d,%d)\n", N, arr[0], arr[1], arr[2]));
			return;
		}
		for(int i = 2; i<N; i++) {
			arr[cnt] = i;
			if(cnt == 0 || arr[cnt] >= arr[cnt-1])
				backTracking(cnt + 1);
		}
	}

}
