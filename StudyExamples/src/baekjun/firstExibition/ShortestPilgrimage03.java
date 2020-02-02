package baekjun.firstExibition;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ShortestPilgrimage03 {
	static class Graph{
		private int n;
		private int maps[][];
		
		public Graph(int n) {
			this.n = n;
			maps = new int[n+1][n+1];
		}
		public void input(int i, int j, int w) {
			maps[i][j] = w;
			maps[j][i] = w;
		}
		public void dijkstra(int v) {
			int distance[][] = new int[n + 1][2];
			boolean[] chk = new boolean[n + 1];
			
			for(int i = 1; i<n+1; i++)
				distance[i][0] = Integer.MAX_VALUE;
			
			distance[v][0] = 0;
			distance[v][1] = 1;
			chk[v] = true;
			
			for(int i = 1; i<n+1; i++) {
				if(!chk[i] && maps[v][i] != 0){
					distance[i][0] = maps[v][i];
					distance[i][1] = 1;
				}
			}
			
			for(int a = 0; a<n-1; a++) {
				int min = Integer.MAX_VALUE;
				int min_index = -1;
				for(int i = 1; i<n+1; i++) {
					if(!chk[i] && distance[i][0] != Integer.MAX_VALUE) {
						if(distance[i][0] < min) {
							min = distance[i][0];
							min_index = i;
						}
					}
				}
				
				chk[min_index] = true;
				for(int i = 1; i<n+1; i++) {
					if(!chk[i] && maps[min_index][i] != 0) {
						if(distance[i][0]>distance[min_index][0] + maps[min_index][i]) {
							distance[i][0] = distance[min_index][0]+maps[min_index][i];
							distance[i][1] = distance[min_index][1] + 1;
						}
					}
				}
				
			}
			System.out.println((distance[n][1] < 7)? -1 : distance[n][0]);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Graph g = new Graph(N);
		for(int m = 0; m<M; m++) {
			st = new StringTokenizer(br.readLine());
			g.input(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		g.dijkstra(1);
	}

}
