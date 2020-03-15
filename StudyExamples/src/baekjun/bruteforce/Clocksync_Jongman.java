package baekjun.bruteforce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Clocksync_Jongman {
	static int INF = 9999;
	static int button[][] = {
			{0, 1, 2}, {3, 7, 9, 11}, {4, 10, 14, 15},
			{0 ,4, 5, 6, 7}, {6, 7, 8, 10, 12}, {0, 2, 14, 15},
			{3, 14, 15}, {4, 5, 7, 14, 15}, {1, 2, 3, 4, 5}, {3, 4, 5, 9, 13}
	};
	
	static boolean isAligned(int clock[]) {
		boolean chk = true;
		for(int i = 0; i<16; i++) {
			if(clock[i] != 0) {
				chk = false;
				break;
			}
		}
		return chk;
	}
	
	static void pushButton(int clock[], int btnNum) {
		for(int i = 0; i<button[btnNum].length; i++) {
			clock[button[btnNum][i]] = (clock[button[btnNum][i]] + 3)%12;
		}
	}
	
	static int solve(int clock[], int btnNum) {
		if(btnNum == 10) return isAligned(clock)? 0 : INF;
		int cnt = INF;
		for(int i = 0; i<4; i++) {
			cnt = Math.min(cnt, i + solve(clock, btnNum + 1));
			pushButton(clock, btnNum);
		}
		return cnt;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCase = Integer.parseInt(br.readLine());
		for(int t = 0; t<testCase; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int clock[] = new int[16];
			for(int i = 0; i<16; i++) {
				int n = Integer.parseInt(st.nextToken());
				if(n == 12) n = 0;
				clock[i] = n;
			}
			int ans = solve(clock, 0);
			bw.write(((ans == INF)? -1 : ans) + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
