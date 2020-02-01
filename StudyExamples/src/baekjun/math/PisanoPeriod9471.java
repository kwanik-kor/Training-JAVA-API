package baekjun.math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class PisanoPeriod9471 {
	static long pisano(int m) {
		int m1, m2, period;
		m1 = m2 = 1;
		period = 0;
		do {
			int temp = m1;
			m1 = m2;
			m2 = (temp + m2)%m;
			period++;
		}while(!(m1 == 1 && m2 == 1));
		
		return period;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int P = Integer.parseInt(br.readLine());
		for(int p = 0; p < P; p++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			long km = pisano(Integer.parseInt(st.nextToken()));
			bw.write(i + " " + km + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
