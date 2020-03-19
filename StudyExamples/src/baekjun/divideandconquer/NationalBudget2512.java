package baekjun.divideandconquer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class NationalBudget2512 {
	static int N, total;
	static int max = 0, ans;
	static int[] local;
	
	static void solve(int left, int right) {
		if(left > right) return;
		
		int budget = (left + right)/2;
		int sum = 0;
		for(int i = 0; i<N; i++) {
			if(local[i] <= budget) sum += local[i];
			else sum += budget;
		}
		
		if(sum > total)
			solve(left, budget - 1);
		else {
			if(max < sum) {
				ans = budget;
				solve(budget + 1, right);
			}else
				solve(budget + 1, right);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		total = Integer.parseInt(br.readLine());
		local = new int[N];
		int max = 0;
		for(int i = 0; i<N; i++) {
			local[i] = Integer.parseInt(st.nextToken());
			max = Math.max(local[i], max);
		}
		if(max * N <= total) bw.write(max + "");
		else {
			solve(0, max);
			bw.write(ans + "");
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
