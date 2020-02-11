package baekjun.dynamic_programming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class PoliceCar2618 {
	static int N, W, total = 0;
	static Point one, two;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		W = Integer.parseInt(br.readLine());
		one = new Point(1, 1);
		two = new Point(N, N);
		StringBuilder sb = new StringBuilder("");
		for(int t = 0; t<W; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int disA = Math.abs(a - one.x) + Math.abs(b - one.y);
			int disB = Math.abs(a - two.x) + Math.abs(b - two.y);
			if(disA < disB) {
				total += disA;
				one.setX(a);
				one.setY(b);
				sb.append("1\n");
			}else {
				total += disB;
				two.setX(a);
				two.setY(b);
				sb.append("2\n");
			}
		}
		bw.write(total + "\n" + sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
	static class Point{
		int x;
		int y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		public void setX(int x) {
			this.x = x;
		}
		public void setY(int y) {
			this.y = y;
		}
		
	}
}
