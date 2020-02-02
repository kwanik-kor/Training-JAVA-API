package baekjun.firstExibition;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class OrderOrChaos07 {
	static int N, comb[], result[];
	static boolean visit[];
	static String TYPE;
	static int max = 0;
	
	static void backTracking(int cnt) {
		if(TYPE.equals("order") && N == 2) {
			result[0] = 1;
			result[1] = 2;
			return;
		}
		if(max == N) return;
		if(cnt == N) {
			int tempMax = 0;
			for(int i = 0; i<N; i++) {
				boolean chk;
				if(i == N-1) chk = isPrime(comb[i] + comb[0]);
				else chk = isPrime(comb[i] + comb[i+1]);
				if(TYPE.equals("chaos") && chk) 
					tempMax++;
				else if(TYPE.equals("order") && !chk)
					tempMax++;
			}
			if(tempMax > max) {
				max = tempMax;
				for(int i = 0; i<N; i++)
					result[i] = comb[i];
			}
			return;
		}
		for(int i = 1; i<=N; i++) {
			if(visit[i]) continue;
			comb[cnt] = i;
			visit[i] = true;
			backTracking(cnt + 1);
			visit[i] = false;
		}
	}
	
	static boolean isPrime(int n) {
		boolean result = true;
		for(int i = 2; i<=Math.sqrt(n); i++) {
			if(n%i == 0) {
				result = false;
				break;
			}
		}
		return result;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		TYPE = st.nextToken();
		N = Integer.parseInt(st.nextToken());
		visit = new boolean[N+1];
		comb = new int[N];
		result = new int[N];
		backTracking(0);
		for(int i = 0; i<N; i++)
			bw.write(result[i]+" ");
		bw.flush();
		bw.close();
		br.close();
	}

}
