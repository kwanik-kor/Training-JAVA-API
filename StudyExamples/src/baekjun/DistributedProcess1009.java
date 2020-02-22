package baekjun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class DistributedProcess1009 {
	static StringTokenizer st;
	
	static int calc(int a, int b) {
		int t = a;
		for(int i = 1; i<b; i++) {
			a *= t;
			a %= 10;
			if(a == 0) a = 10;
		}
		return a;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCase = Integer.parseInt(br.readLine());
		for(int t = 0; t<testCase; t++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			bw.write(calc(a, b) + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
