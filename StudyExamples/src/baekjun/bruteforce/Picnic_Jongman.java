package baekjun.bruteforce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Picnic_Jongman {
	static boolean areFriends[][];
	
	static int countPairing(boolean[] hasFriend) {
		int idx = -1;
		for(int i = 0; i<hasFriend.length; i++) {
			if(!hasFriend[i]) {
				idx = i;
				break;
			}
		}
		if(idx == -1) return 1;
		int cnt = 0;
		for(int pair = idx + 1; pair<hasFriend.length; pair++) {
			if(!hasFriend[pair] && areFriends[idx][pair]) {
				hasFriend[idx] = hasFriend[pair] = true;
				cnt += countPairing(hasFriend);
				hasFriend[idx] = hasFriend[pair] = false;
			}
		}
		return cnt;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCase = Integer.parseInt(br.readLine());
		for(int t = 0; t<testCase; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			areFriends = new boolean[n][n];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i<m; i++) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				areFriends[a][b] = areFriends[b][a] = true;
			}
			
			boolean hasFriend[] = new boolean[n];
			bw.write(countPairing(hasFriend) + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
