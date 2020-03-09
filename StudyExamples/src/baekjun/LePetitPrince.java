package baekjun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class LePetitPrince {
	static int x1, y1, x2, y2;
	
	static int solve(Planet p){
		int d1 = (p.x - x1)*(p.x - x1) + (p.y - y1)*(p.y - y1);
		int d2 = (p.x - x2)*(p.x - x2) + (p.y - y2)*(p.y - y2);
		int r = p.r*p.r;
		if(d1 > r && d2 < r || d1 < r && d2 > r)
			return 1;
		else 
			return 0;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCase = Integer.parseInt(br.readLine());
		for(int t = 0; t<testCase; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(br.readLine());
			int cnt = 0;
			for(int i = 0 ; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				Planet p = new Planet(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
				cnt += solve(p);
			}
			bw.write(cnt+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	static class Planet{
		int x;
		int y;
		int r;
		public Planet(int x, int y, int r) {
			this.x = x;
			this.y = y;
			this.r = r;
		}
	}
}
