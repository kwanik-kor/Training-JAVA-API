package baekjun.divideandconquer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class ColorPaper1780 {
	static int N;
	static int result[] = new int[3];
	static int map[][];
	
	static boolean check(int a, int b, int n) {
		int temp = map[a][b];
		for(int i = a; i<a+n; i++) {
			for(int j = b; j<b+n; j++){
				if(temp != map[i][j]) return false;
			}
		}
		result[temp+1]++;
		return true;
	}
	
	static void divide(int a, int b, int n) {
		if(!check(a, b, n)) {
			int temp = n/3;
			for(int i = 0; i<3; i++) {
				for(int j = 0; j<3; j++)
					divide(a + temp*i, b + temp*j, temp);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		StringTokenizer st;
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<N; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		divide(0,0,N);
		for(int i = 0; i<3; i++)
			bw.write(result[i] + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

}
