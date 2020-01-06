package baekjun.recursive;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Star2447 {
	public static char[][] arr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		arr = new char[N][N];
		for(int i = 0; i<N; i++) {
			Arrays.fill(arr[i], ' ');
		}
		starArray(0,0,N);
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				bw.write(arr[i][j]);
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void starArray(int x, int y, int num) {
		if(num == 1) {
			arr[x][y] = '*';
			return;
		}
		int val = num/3;
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(!(i == 1 && j == 1))
					starArray(x + val*i, y + val*j, val);
			}
		}
	}
}
