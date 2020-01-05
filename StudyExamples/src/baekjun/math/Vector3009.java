package baekjun.math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Vector3009 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[] x = new int[1001];
		int[] y = new int[1001];
		for(int i = 0; i<3; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			x[Integer.parseInt(st.nextToken())]++;
			y[Integer.parseInt(st.nextToken())]++;
		}
		for(int i = 0; i<x.length; i++) {
			if(x[i]%2 == 1)
				bw.write(i + " ");
		}
		for(int i = 0; i<y.length; i++) {
			if(y[i]%2 == 1)
				bw.write(String.valueOf(i));
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
