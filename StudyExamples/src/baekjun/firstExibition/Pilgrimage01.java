package baekjun.firstExibition;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Pilgrimage01 {
	static int N, M, relic[][], totalP, totalW;
	static double result[];
	static int temp[];
	static boolean visit[];
	static StringTokenizer st;
	static double maxPrice;
	
	static void maxConvenience() {
		temp = new int[N+1];
		maxPrice = 0;
		backTracking(0);
	}
	
	static void backTracking(int cnt) {
		if(cnt == M) {
			int P = totalP;
			int W = totalW;
			for(int i = 0; i<M; i++) {
				P -= relic[temp[i]][0];
				W -= relic[temp[i]][1];
			}
			maxPrice = Math.max(maxPrice, (double)P/W);
			return;
		}
		for(int i = 1; i<=M+8; i++) {
			if(visit[i]) continue;
			temp[cnt] = i;
			visit[i] = true;
			if(cnt == 0 || (cnt > 0 && temp[cnt] > temp[cnt-1]))
				backTracking(cnt + 1);
			visit[i] = false;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		relic = new int[N+1][2];
		visit = new boolean[N+1];
		result = new double[N+1];
		totalP = 0;
		totalW = 0;
		for(int i = 1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			relic[i][0] = Integer.parseInt(st.nextToken());
			relic[i][1] = Integer.parseInt(st.nextToken());
			totalP += relic[i][0];
			totalW += relic[i][1];
			if(i <= 8)
				result[i] = (double)totalP/totalW;
			else {
				M = i - 8;
				for(int j = 1; j<=N; j++)
					visit[j] = false;
				maxConvenience();
				result[i] = maxPrice;
			}
		}
		for(int i = 8; i<=N; i++)
			bw.write(result[i]+"\n");
		bw.flush();
		bw.close();
		br.close();
	}

}
