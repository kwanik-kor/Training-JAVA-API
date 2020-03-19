package baekjun.bruteforce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class CalcDate1476 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int E = Integer.parseInt(st.nextToken())-1;
		int S = Integer.parseInt(st.nextToken())-1;
		int M = Integer.parseInt(st.nextToken())-1;
		int a = 0;
		int b = 0;
		int c = 0;
		int year = 1;
		while(true) {
			if(E == a && S == b && M == c) break;
			a = (a+1)%15;
			b = (b+1)%28;
			c = (c+1)%19;
			year++;
		}
		bw.write(year + "");
		bw.flush();
		bw.close();
		br.close();
	}

}
