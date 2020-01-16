package baekjun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BetweentheMountains9558 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int k = 0; k<T; k++) {
			int a[] = altitudes(br.readLine());
			int b[] = altitudes(br.readLine());
			int min = 10000000;
			for(int i = 0; i<a.length; i++) {
				for(int j = 0; j<b.length; j++) {
					if(Math.abs(a[i] - b[j])<min)
						min = Math.abs(a[i]-b[j]);
				}
			}
			bw.write(min + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	static int[] altitudes(String s) {
		StringTokenizer st = new StringTokenizer(s);
		int n = Integer.parseInt(st.nextToken());
		int a[] = new int[n];
		for(int i = 0; i<n; i++)
			a[i] = Integer.parseInt(st.nextToken());
		return a;
	}
}
