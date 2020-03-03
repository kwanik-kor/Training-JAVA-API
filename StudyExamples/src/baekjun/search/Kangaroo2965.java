package baekjun.search;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Kangaroo2965 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int cnt = 0;
		while(true) {
			if(A+1 == B && B+1 == C) break;
			if(B-A >= C-B) {
				C = B;
				B = A+1;
			}else {
				A = B;
				B = A+1;
			}
			cnt++;
		}
		bw.write(cnt + "");
		bw.flush();
		bw.close();
		br.close();
	}

}
