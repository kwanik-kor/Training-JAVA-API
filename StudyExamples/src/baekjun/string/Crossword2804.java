package baekjun.string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Crossword2804 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String A = st.nextToken();
		String B = st.nextToken();
		int n = A.length();
		int m = B.length();
		int idx_a = -1;
		int idx_b = -1;
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<m; j++) {
				if(A.charAt(i) == B.charAt(j)) {
					idx_a = i;
					idx_b = j;
					break;
				}
			}
			if(idx_a != -1) break;
		}
		for(int i = 0; i<m; i++) {
			for(int j = 0; j<n; j++) {
				if(i == idx_b)
					bw.write(A.charAt(j));
				else if(j == idx_a)
					bw.write(B.charAt(i));
				else
					bw.write(".");
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
