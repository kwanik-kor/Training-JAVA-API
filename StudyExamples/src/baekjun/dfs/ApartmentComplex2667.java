package baekjun.dfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ApartmentComplex2667 {
	static int N, map[][];
	static int x[] = {-1, 0, 1, 0};
	static int y[] = {0, -1, 0, 1};
	static List<Integer> arr = new ArrayList<>();
	static int cnt = 1;
	
	static void dfs(int a, int b, int k) {
		if(arr.size() == k) arr.add(1);
		else arr.set(k, arr.get(k) + 1);
		
		map[a][b] = k;
		for(int i = 0; i<4; i++) {
			int dx = a + x[i];
			int dy = b + y[i];
			if(dx > -1 && dx < N && dy > -1 && dy < N && map[dx][dy] == 1)
				dfs(dx, dy, k);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		String s;
		map = new int[N][N];
		arr.add(0); arr.add(0);
		for(int i = 0; i<N; i++) {
			s = br.readLine();
			for(int j = 0; j<N; j++)
				map[i][j] = Integer.parseInt(s.charAt(j)+"");
		}
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				if(map[i][j] == 1)
					dfs(i, j, ++cnt);
			}
		}
		bw.write(cnt - 1 + "\n");
		Collections.sort(arr);
		if(arr.size()>2) {
			for(int i = 2; i<arr.size(); i++) {
				bw.write(arr.get(i) + "\n");
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
