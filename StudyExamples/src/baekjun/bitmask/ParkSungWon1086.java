package baekjun.bitmask;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class ParkSungWon1086 {
	static int N, K, arr[], ten[];
	static String str[];
	static long dp[][] = new long[1 << 15][101];
	
	static void initArr() {
		arr = new int[N];
		for(int i = 0; i<N; i++) {
			int t = 0;
			for(int j = 0; j<str[i].length(); j++) {
				t *= 10;
				t %= K;
				t += str[i].charAt(j) - '0';
				t %= K;
			}
			arr[i] = t;
		}
	}
	
	static long dp(int bit, int nmg) {
		if(dp[bit][nmg] != -1) return dp[bit][nmg];
		if(bit + 1 == 1 << N) {
			if(nmg == 0) return 1;
			else return 0;
		}
		dp[bit][nmg] = 0;
		for(int i = 0; i<N; i++) {
			if((bit & (1 << i)) == 0) {
				int temp = nmg * ten[str[i].length()] + arr[i];
				dp[bit][nmg] += dp(bit | (1 << i), temp % K);
			}
		}
		return dp[bit][nmg];
	}
	
	static long gcd(long a, long b) {
		return (a % b == 0)? b : gcd(b, a%b);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		str = new String[N];
		for(int i = 0; i<N; i++)
			str[i] = br.readLine();
		K = Integer.parseInt(br.readLine());
		initArr(); //K로 나눈 나머지를 배열에 저장
		ten = new int[51];
		ten[0] = 1;
		for(int i = 1; i<51; i++)
			ten[i] = ten[i-1] * 10 % K;
		for(int i = 0; i<dp.length; i++)
			Arrays.fill(dp[i], -1);
		long p = dp(0, 0);
		long q = 1;
		if(p == 0)
			bw.write("0/1");
		else{
			for(int i = 1; i<=N; i++)
				q *= i;
			long gcd = gcd(p, q);
			bw.write(p/gcd + "/" + q/gcd);
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
