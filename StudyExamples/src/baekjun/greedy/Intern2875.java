package baekjun.greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Intern2875 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int max = 0;
		for(int i = 0; i<=K; i++) {
			int n = N-i;
			int m = M-(K-i);
			int result = (n>=m*2)? m : n/2;
			max = Math.max(max, result);
		}
		bw.write(max+"");
		bw.flush();
		bw.close();
		br.close();
	}

}
