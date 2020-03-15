package baekjun.bruteforce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Retirement14501 {
	static int N, max;
	static Council[] schedule;
	
	static void maxBenefit(int idx, int sum) {
		if(idx == N) {
			max = Math.max(max, sum);
			return;
		}
		if(idx + schedule[idx].day <= N) {
			maxBenefit(idx + schedule[idx].day, sum + schedule[idx].val);
		}
		maxBenefit(idx + 1, sum);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		schedule = new Council[N];
		for(int i = 0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			schedule[i] = new Council(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		maxBenefit(0, 0);
		bw.write(max + "");
		bw.flush();
		bw.close();
		br.close();
	}
	
	static class Council{
		int day;
		int val;
		public Council(int day, int val) {
			this.day = day;
			this.val = val;
		}
	}
}
