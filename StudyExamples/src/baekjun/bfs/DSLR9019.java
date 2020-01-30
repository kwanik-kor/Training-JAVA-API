package baekjun.bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DSLR9019 {
	static int START, END;
	static boolean chk[];
	
	static String BFS() {
		String result = "";
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(START, ""));
		while(!q.isEmpty()) {
			Point p = q.poll();
			if(p.n == END) {
				result = p.s;
				break;
			}
			for(int i = 0; i<4; i++) {
				int temp;
				switch(i) {
				case 0:
					temp = (p.n*2 > 9999)? p.n*2%10000 : p.n*2;
					if(!chk[temp]) {
						q.add(new Point(temp, p.s + "D"));
						chk[temp] = true;
					}
					break;
				case 1:
					temp = (p.n == 0)? 9999 : p.n - 1;
					if(!chk[temp]) {
						q.add(new Point(temp, p.s + "S"));
						chk[temp] = true;
					}
					break;
				case 2:
					temp = p.n*10%10000 + p.n*10/10000;
					if(!chk[temp]) {
						q.add(new Point(temp, p.s + "L"));
						chk[temp] = true;
					}
					break;
				default:
					temp = p.n/10 + p.n%10*1000;
					if(!chk[temp]) {
						q.add(new Point(temp, p.s + "R"));
						chk[temp] = true;
					}
					break;
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t<T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			START = Integer.parseInt(st.nextToken());
			END = Integer.parseInt(st.nextToken());
			chk = new boolean[10001];
			bw.write(BFS() + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	static class Point{
		int n;
		String s;
		Point(int n, String s){
			this.n = n;
			this.s = s;
		}
	}
}
