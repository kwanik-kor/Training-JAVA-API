package baekjun.bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Fire5427 {
	static int h, w;
	static int result;
	static int[][] map;
	static Queue<int[]> fire, man;
	static int[] dy = {0, 1, 0, -1};
	static int[] dx = {1, 0, -1, 0};
	
	static void bfs() {
		while(!fire.isEmpty() || !man.isEmpty()) {
			int size1 = fire.size();
			if(size1 > 0) {
				while(size1-- > 0) {
					int y = fire.peek()[0];
					int x = fire.peek()[1];
					fire.poll();
					
					for(int dir = 0; dir<4; dir++) {
						int ny = y + dy[dir];
						int nx = x + dx[dir];
						
						if(ny < 0 || nx < 0 || ny >= h || nx >= w) continue;
						if(map[ny][nx] == -1 || map[ny][nx] == -2) continue;
						
						map[ny][nx] = -2;
						fire.add(new int[] {ny, nx});
					}
				}
			}
			
			int size2 = man.size();
			boolean flag = false;
			if(size2 > 0 ) {
				while(size2-- > 0) {
					int y = man.peek()[0];
					int x = man.peek()[1];
					int val = man.peek()[2];
					man.poll();
					
					for(int dir = 0; dir<4; dir++) {
						int ny = y + dy[dir];
						int nx = x + dx[dir];
						if(ny < 0 || ny >= h || nx < 0 || nx >= w) {
							result = val + 1;
							flag = true;
							break;
						}
						if(map[ny][nx] == 0) {
							map[ny][nx] = val + 1;
							man.offer(new int[] {ny, nx, val + 1});
						}
					}
					
					if(flag) break;
				}
				if(flag) break;
			}else {
				result = -1;
				break;
			}
		}
	}
	
    static int getVal(char c) {
        switch(c) {
            case '#': return -1;
            case '*': return -2;
            case '@': return 1; 
            default: return 0;
        }
    }
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCase = Integer.parseInt(br.readLine());
		for(int t = 0; t<testCase; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			map = new int[h][w];
			man = new LinkedList<>();
			fire = new LinkedList<>();
			result = 0;
			
			for(int i = 0; i<h; i++) {
				String tmp = br.readLine();
				for(int j = 0; j<w; j++) {
					map[i][j] = getVal(tmp.charAt(j));
					if(map[i][j] == -2)
						fire.offer(new int[] {i, j});
					if(map[i][j] == 1)
						man.offer(new int[] {i, j, 0});
				}
			}
			bfs();
			bw.write((result > 0)? result + "\n" : "IMPOSSIBLE\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}

}
