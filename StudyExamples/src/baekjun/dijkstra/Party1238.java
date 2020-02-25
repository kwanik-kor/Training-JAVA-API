package baekjun.dijkstra;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Party1238 {
	static StringTokenizer st;
	static int N, M, X;
	static int dist[][];
	static int INF = 1000000000;
	
	static void floyd() {
		for(int k = 1; k <= N; k++) {
			for(int i = 1; i<=N; i++) {
				for(int j = 1; j<=N; j++) {
					if(dist[i][j] > dist[i][k] + dist[k][j]) {
						dist[i][j] = dist[i][k] + dist[k][j];
					}
				}
			}
		}
	}
	
	static int check() {
		int max = 0;
		for(int i = 1; i<=N; i++) {
			max = Math.max(max, dist[i][X] + dist[X][i]);
		}
		return max;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		dist = new int[N+1][N+1];
		for(int i = 1; i<=N; i++) {
			for(int j = 1; j<=N; j++) {
				if(i == j) continue;
				dist[i][j] = INF;
			}
		}
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			dist[a][b] = Math.min(v, dist[a][b]);
		}
		floyd();
		bw.write(check() + "");
		bw.flush();
		bw.close();
		br.close();
	}

}
