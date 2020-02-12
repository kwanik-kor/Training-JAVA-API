package baekjun.dynamic_programming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PoliceCar2618 {
	static int N, W, dp[][];
	static Pos[] incident;
	static StringBuilder sb = new StringBuilder("");
	
	static int minDistance(int p1, int p2) {
		if(p1 == W || p2 == W) return 0;
		if(dp[p1][p2] != -1) return dp[p1][p2];
		
		int next = Math.max(p1, p2) + 1;
		int arr[] = getNextDist(next, p1, p2);
		
		dp[p1][p2] = Math.min(minDistance(next, p2) + arr[0], minDistance(p1, next) + arr[1]);
		return dp[p1][p2];
	}
	
	static void whichAuto(int num, int p1, int p2) {
		if(num == W) return;
		int next = Math.max(p1, p2) + 1;
		int arr[] = getNextDist(next, p1, p2);
		
		if(minDistance(next, p2) + arr[0] >= minDistance(p1, next) + arr[1]) {
			sb.append("2\n");
			whichAuto(num + 1, p1, next);
		}else {
			sb.append("1\n");
			whichAuto(num + 1, next, p2);
		}
	}
	
	static int[] getNextDist(int next, int p1, int p2) {
		int arr[] = new int[2];
		if(p1 == 0) arr[0] = getDistance(new Pos(1,1), incident[next-1]);
		else arr[0] = getDistance(incident[p1 - 1], incident[next-1]);
		if(p2 == 0) arr[1] = getDistance(new Pos(N, N), incident[next-1]);
		else arr[1] = getDistance(incident[p2 - 1], incident[next-1]);
		return arr;
	}
	
	static int getDistance(Pos start, Pos end) {
		return Math.abs(end.x - start.x) + Math.abs(end.y - start.y);
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		W = Integer.parseInt(br.readLine());
		incident = new Pos[W];
		dp = new int[W+1][W+1];
		for(int i = 0; i<=W; i++) {
			Arrays.fill(dp[i], -1);
		}
		for(int i = 0; i<W; i++) {
			st = new StringTokenizer(br.readLine());
			incident[i] = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		bw.write(minDistance(0,0) + "\n");
		whichAuto(0,0,0);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
	static class Pos{
		int x;
		int y;
		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
