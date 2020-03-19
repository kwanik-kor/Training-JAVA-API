package baekjun.divideandconquer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class PocketMoney6236 {
	static int N, M, ans;
	static int[] money;
	
	static void solve(int left, int right) {
		if(left > right) return;
		
		int limit = (left + right)/2;
		int change = 0;
		int cnt = 0;
		boolean flag = true;
		for(int i = 0; i<N; i++) {
			if(money[i] > limit) {
				flag = false;
				break;
			}
			if(money[i] > change) {
				change = limit;
				cnt++;
			}else if((M - cnt) == (N-i)) {
				change = limit;
				cnt++;
			}
			change -= money[i];
		}
		
		if(!flag || cnt > M) 
			solve(limit + 1, right);
		else if(cnt == M) {
			ans = limit;
			solve(left, limit - 1);
		}else
			solve(left, limit - 1);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		money = new int[N];
		int min = 10000;
		int sum = 0;
		for(int i = 0; i<N; i++) {
			money[i] = Integer.parseInt(br.readLine());
			sum += money[i];
			min = Math.min(min, money[i]);
		}
		solve(min, sum);
		bw.write(ans + "");
		bw.flush();
		bw.close();
		br.close();
	}

}
