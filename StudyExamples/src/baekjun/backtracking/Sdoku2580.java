package baekjun.backtracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Sdoku2580 {
	static int N = 9;
	static int[][] map = new int[N][N];
	static boolean chk;
	static int size;
	static ArrayList<Node> list = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i = 0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 0)
					list.add(new Node(i, j));
			}
		}
		size = list.size();
		solve(0,0);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void solve(int idx, int cnt) {
		if(chk) return;
		if(cnt == size) {
			chk = true;
			for(int i = 0; i<9; i++) {
				for(int j = 0; j<9; j++) {
					sb.append(map[i][j] + " ");
				}
				sb.append("\n");
			}
			return;
		}
		Node node = list.get(idx);
		for(int i = 1; i<=9; i++) {
			if(!isPossible(node.x, node.y, i))
				continue;
			map[node.x][node.y] = i;
			solve(idx + 1, cnt + 1);
			if(chk) return;
			map[node.x][node.y] = 0;
		}
	}
	
	static boolean isPossible(int x, int y, int z) {
		for(int i = 0; i<N; i++) {
			if(map[i][y] == z || map[x][i] == z)
				return false;
		}
		for(int i = (x/3)*3; i<(x/3)*3 + 3; i++) {
			for(int j = (y/3)*3; j<(y/3)*3 + 3; j++) {
				if(map[i][j] == z)
					return false;
			}
		}
		return true;
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
