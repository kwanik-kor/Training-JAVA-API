package baekjun.bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Tomato7576 {
	static int N, M, map[][];
	static int x[] = {-1, 0, 1, 0};
	static int y[] = {0, 1, 0, -1};
	
	static void bfs() {
		Queue<Node> q = new LinkedList<>();
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				if(map[i][j] == 1) q.add(new Node(i, j));
			}
		}
		
		while(!q.isEmpty()) {
			Node n = q.poll();
			for(int i = 0; i<4; i++) {
				int nextX = n.x + x[i];
				int nextY = n.y + y[i];
				if(nextX > -1 && nextX < N && nextY > -1 && nextY <M && map[nextX][nextY] == 0) {
					q.add(new Node(nextX, nextY));
					map[nextX][nextY] = map[n.x][n.y] + 1;
				}
			}
		}
	}
	
	static int findDay() {
		int result = 1;
		boolean never = false;
		for(int i = 0; i<N; i++) {
			if(never) break;
			for(int j = 0; j<M; j++) {
				if(map[i][j] == 0) {
					never = true;
					break;
				}else if(map[i][j] > result)
					result = map[i][j];
			}
		}
		return (never)? -1 : result - 1;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<M; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		bfs();
		bw.write(findDay()+"");
		bw.flush();
		bw.close();
		br.close();
	}
}

class Node {
	int x;
	int y;
	Node(int x, int y){
		this.x = x;
		this.y = y;
	}
}
