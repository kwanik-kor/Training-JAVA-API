package baekjun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class DoNotTouchAnything13136 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		if(R % N == 0) R /= N;
		else R = R/N + 1;
		if(C % N == 0) C /= N;
		else C = C/N + 1;
		bw.write((long)R*C + "");
		bw.flush();
		bw.close();
		br.close();
	}

}
