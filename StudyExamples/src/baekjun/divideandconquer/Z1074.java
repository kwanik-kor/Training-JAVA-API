package baekjun.divideandconquer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Z1074 {
	static int N, r, c;
	static int num = 0;
	static int ans;
	
	static void search(int y, int x, int size) {
		//size = 변의 길이
		if(size == 1) {
			if(y == r && x == c)
				ans = num;
			num++;
			return;
		}
		int mid = size/2;
		search(y, x, mid);
		search(y, x + mid, mid);
		search(y + mid, x, mid);
		search(y + mid, x + mid, mid);
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		search(0, 0, (int)Math.pow(2, N));
		bw.write(ans+"");
		bw.flush();
		bw.close();
		br.close();
	}

}
