package baekjun.bruteforce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class MarbleEscape13460 {
	static int N, M;
	static int min = 987654321;
	//top, right, bottom, left
	static int dy[] = {-1, 0, 1, 0};
	static int dx[] = {0, 1, 0, -1};
	
	static void solve(String[][] map, int count, Point R, Point B) {
		//조건 1. 움직이는 전체 횟수가 11 이상이 되면 안된다.
		//조건 2. 파란색이 빠지면 안된다. (빨간색 && !파란색)
		if(count >= min) return;
		if(count > 10) return;
		
		for(int dir = 0; dir<4; dir++) {
			boolean red = false;
			boolean blue = false;
			
			Point new_R = new Point(R.y, R.x);
			Point new_B = new Point(B.y, B.x);
			//빨간공 움직이기
			while(true) {
				new_R.y += dy[dir];
				new_R.x += dx[dir];
				if(map[new_R.y][new_R.x].equals("O")) {
					red = true;
					break;
				}else if(map[new_R.y][new_R.x].equals("#"))
					break;
			}
			new_R.y -= dy[dir];
			new_R.x -= dx[dir];
			
			//파란공 움직이기
			while(true) {
				new_B.y += dy[dir];
				new_B.x += dx[dir];
				if(map[new_B.y][new_B.x].equals("O")) {
					blue = true;
					break;
				}else if(map[new_B.y][new_B.x].equals("#"))
					break;
			}
			new_B.y -= dy[dir];
			new_B.x -= dx[dir];
			
			if(blue) return; //퍼런게 빠지면 무조건 리턴
			else {
				if(red) {
					min = Math.min(min, count+1);
					return; //뻘건거만 빠지면 값 갱신하고 리턴
				}
			}
			
			//아무것도 안빠졌고 && 뻘건것과 퍼런 것의 좌표가 같다면 다시 조절해쥬쟈
			if(new_R.y == new_B.y && new_R.x == new_B.x) {
				if(dx[dir] == 0) { //y축 이동이었던 경우
					if(Math.abs(R.y - new_R.y) > Math.abs(B.y - new_B.y)) //빨간게 더 많이 움직였으면
						new_R.y -= dy[dir];
					else
						new_B.y -= dy[dir];
				}else { //x축 이동이었던 경우
					if(Math.abs(R.x - new_R.x) > Math.abs(B.x - new_B.x)) //빨간게 더 많이 움직였으면
						new_R.x -= dx[dir];
					else
						new_B.x -= dx[dir];
				}
			}
			//조절된 좌표로 다시 출발
			solve(map, count + 1, new_R, new_B);
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		String map[][] = new String[N][M];
		Point R = null, B = null;
		for(int i = 0; i<N; i++) {
			String tmp[] = br.readLine().split("");
			for(int j = 0; j<M; j++) {
				map[i][j] = tmp[j];
				if(map[i][j].equals("R")) {
					R = new Point(i, j);
					map[i][j] = ".";
				}
				if(map[i][j].equals("B")) {
					B = new Point(i, j);
					map[i][j] = ".";
				}
			}
		}
		solve(map, 0, R, B);
		min = (min > 10 || min == 987654321)? -1 : min;
		bw.write(String.valueOf(min));
		bw.flush();
		bw.close();
		br.close();
	}
	
	static class Point{
		int y;
		int x;
		public Point(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}
