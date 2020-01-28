package baekjun.divideandconquer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class QuadTree1992 {
	static int N, point;
	static int map[][];
	static StringBuilder sb = new StringBuilder();
	
	static boolean check(int a, int b, int n) {
		int temp = map[a][b];
		for(int i = a; i<a+n; i++) {
			for(int j = b; j<b+n; j++) {
				if(map[i][j] != temp)
					return false;
			}
		}
		point = temp;
		return true;
	}
	
	static void divide(int a, int b, int n) {
		if(check(a,b,n)) sb.append(String.valueOf(point));
		else {
			sb.append("(");
			int temp = n/2;
			for(int i = 0; i<2; i++) {
				for(int j = 0; j<2; j++)
					divide(a + temp*i, b + temp*j, temp);
			}
			sb.append(")");
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for(int i = 0; i<N; i++) {
			char temp[] = br.readLine().toCharArray();
			for(int j = 0; j<N; j++)
				map[i][j] = temp[j] - '0';
		}
		divide(0, 0, N);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}
