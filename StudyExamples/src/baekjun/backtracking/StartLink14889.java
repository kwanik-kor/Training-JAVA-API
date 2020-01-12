package baekjun.backtracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class StartLink14889 {
	static int N;
	static int stat[][];
	static boolean visited[];
	static int min = 40001;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		stat = new int[N+1][N+1];
		visited = new boolean[N+1];
		for(int i = 1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j<=N; j++) {
				stat[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		combination(1, 0);
		bw.write(String.valueOf(min));
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void combination(int start, int depth) {
		if(depth == N/2) {
			if(getDifference() < min)
				min = getDifference();
			return;
		}
		for(int i = start; i<N+1; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			combination(i+1, depth+1);
			visited[i] = false;
		}
	}
	
	static int getDifference() {
		int sumStart = 0;
		int sumLink = 0;
		for(int i = 1; i<=N; i++) {
			for(int j = 1; j<=N; j++) {
				if(visited[i] && visited[j])
					sumStart += stat[i][j];
				if(!visited[i] && !visited[j])
					sumLink += stat[i][j];
			}
		}
		return Math.abs(sumStart - sumLink);
	}
}
