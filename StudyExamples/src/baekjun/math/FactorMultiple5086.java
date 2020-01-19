package baekjun.math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class FactorMultiple5086 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String s = "";
		StringTokenizer st;
		while(!(s = br.readLine()).equals("0 0")) {
			st = new StringTokenizer(s);
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			if(n>m) {
				if(n%m == 0)
					bw.write("multiple\n");
				else
					bw.write("neither\n");
			}else {
				if(m%n == 0)
					bw.write("factor\n");
				else
					bw.write("neither\n");
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
