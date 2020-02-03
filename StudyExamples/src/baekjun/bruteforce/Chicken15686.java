package baekjun.bruteforce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Chicken15686 {
	static int N, M, map[][];
	static ArrayList<Node> chicken = new ArrayList<>();
	static ArrayList<Node> house = new ArrayList<>();
	static boolean visit[];
	static int selected[];
	static int result = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) chicken.add(new Node(i, j));
				else if(map[i][j] == 1) house.add(new Node(i, j));
			}
		}
		visit = new boolean[chicken.size()];
		selected = new int[chicken.size()];
		selectChicken(0);
		bw.write(result+"");
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void selectChicken(int cnt) {
		if(cnt == M) {
			int sum = 0;
			for(int i = 0; i<house.size(); i++) {
				int min = Integer.MAX_VALUE;
				for(int j = 0; j<M; j++)
					min = Math.min(min, calcDistance(house.get(i), chicken.get(selected[j])));
				sum += min;
			}
			result = Math.min(sum, result);
		}
		for(int i = 0; i<chicken.size(); i++) {
			if(visit[i]) continue;
			selected[cnt] = i;
			visit[i] = true;
			if(cnt == 0 || (cnt>0 && selected[cnt-1]<selected[cnt]))
				selectChicken(cnt + 1);
			visit[i] = false;
		}
	}
	
	static int calcDistance(Node a, Node b) {
		return Math.abs(a.x-b.x) + Math.abs(a.y-b.y);
	}
	
	static class Node{
		int x;
		int y;
		Node(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
}
