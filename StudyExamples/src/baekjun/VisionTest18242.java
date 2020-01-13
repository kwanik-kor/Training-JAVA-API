package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class VisionTest18242 {
	static int N, M;
	static char arr[][];
	static ArrayList<Node> node = new ArrayList<>();
	static int size;
	static String result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new char[N][M];
		
		for(int i = 0; i<N; i++) {
			String s = br.readLine();
			for(int j = 0; j<M; j++) {
				arr[i][j] = s.charAt(j);
				if(arr[i][j] == '#')
					node.add(new Node(i, j));
			}
		}
		size = (node.size() + 5)/4;
		solve();
		System.out.println(result);
		br.close();
	}
	
	static void solve() {
		int x[] = new int[size];
		int y[] = new int[size];
		int gap_x = node.get(0).x;
		int gap_y = node.get(0).y;
		for(Node n : node) {
			x[n.x - gap_x]++;
			y[n.y - gap_y]++;
		}
		if(x[0] == size-1) {
			result = "UP";
			return;
		}
		if(x[size-1] == size-1) {
			result = "DOWN";
			return;
		}
		if(y[0] == size-1) {
			result = "LEFT";
			return;
		}
		if(y[size-1] == size-1) {
			result = "RIGHT";
			return;
		}	
		
	}
}

class Node{
	int x;
	int y;
	Node(int x, int y){
		this.x = x;
		this.y = y;
	}
}