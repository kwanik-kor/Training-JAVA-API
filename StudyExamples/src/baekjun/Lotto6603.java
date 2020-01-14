package baekjun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Lotto6603 {
	static int arr[];
	static int result[];
	static boolean visit[];
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		while(true) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			if(k == 0) break;
			
			arr = new int[k];
			visit = new boolean[k+1];
			result = new int[6];
			for(int i = 0; i<k; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			backTracking(0);
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void backTracking(int cnt) {
		if(cnt == 6) {
			for(int i = 0; i<6; i++) {
				sb.append(result[i] + " ");
			}
			sb.append("\n");
			return;
		}
		for(int i = 0; i<arr.length; i++) {
			if(visit[i]) continue;
			visit[i] = true;
			result[cnt] = arr[i];
			if(cnt == 0 || (cnt > 0 && result[cnt] > result[cnt-1]))
				backTracking(cnt + 1);
			visit[i] = false;
		}
	}
}
