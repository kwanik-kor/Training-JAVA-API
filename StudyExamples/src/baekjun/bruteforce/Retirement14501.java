package baekjun.bruteforce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Retirement14501 {
	static int max = 0;
	static int schedule[][];
	
	static void maxBenefit(int n, int idx, int sum) {
		if(idx == n) {
			max = Math.max(max, sum);
			return;
		}
		if(idx + schedule[idx][0] <= n) {
			maxBenefit(n, idx + schedule[idx][0], sum + schedule[idx][1]);
		}
		maxBenefit(n, idx + 1, sum);
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		schedule = new int[n][2];
		for(int i = 0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			schedule[i][0] = Integer.parseInt(st.nextToken());
			schedule[i][1] = Integer.parseInt(st.nextToken());
		}
		maxBenefit(n, 0, 0);
		bw.write(max + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
