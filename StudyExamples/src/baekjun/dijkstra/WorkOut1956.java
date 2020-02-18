package baekjun.dijkstra;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class WorkOut1956 {
	static int V, E, INF = 1000000000;
	static int dist[][];
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		dist = new int[V+1][V+1];
		for(int i = 1; i<=V; i++) {
			for(int j = 1; j<=V; j++)
				dist[i][j] = INF;
		}
		
		for(int i = 0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			dist[s][e] = v;
		}
		
		for(int k = 1; k<=V; k++) {
			for(int i = 1; i<=V; i++) {
				for(int j = 1; j<=V; j++) {
					if(dist[i][j] > dist[i][k] + dist[k][j])
						dist[i][j] = dist[i][k] + dist[k][j];
				}
			}
		}
		
		int result = Integer.MAX_VALUE;
		for(int i = 1; i<=V; i++)
			result = Math.min(result, dist[i][i]);
		bw.write(((result >= INF)? -1 : result) + "");
		bw.flush();
		bw.close();
		br.close();
	}

}
