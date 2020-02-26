package baekjun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class RemoteController1107 {
	static int N, M;
	static boolean broken[] = new boolean[10];
	static StringTokenizer st;
	
	static int countMoving(int num) {
		int cnt = 0;
		if(num == 0) return broken[0]? 0 : 1;
		while(num > 0) {
			if(broken[num%10]) return 0;
			cnt++;
			num /= 10;
		}
		return cnt;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		if(M > 0) 
			st = new StringTokenizer(br.readLine());
		if(N == 100) bw.write("0");
		else {
			for(int i = 0; i<M; i++) 
				broken[Integer.parseInt(st.nextToken())] = true;
			int ans = Math.abs(N-100);
			for(int i = 0; i<=1000000; i++) {
				int count = countMoving(i);
				if(count > 0) {
					ans = Math.min(ans, Math.abs(N-i) + count);
				}
			}
			bw.write(ans+"");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
