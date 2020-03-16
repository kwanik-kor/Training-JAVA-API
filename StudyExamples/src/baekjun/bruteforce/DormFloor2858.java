package baekjun.bruteforce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class DormFloor2858 {
	static int R, B;
	static int L, W;
	
	static void solve() {
		int condition_1 = R+B; //L*W = R+B
		int condition_2 = B; //(L-2)(W-2) = B
		for(int w = 3; w<=Math.sqrt(condition_1); w++) {
			if(condition_1 % w != 0) continue;
			int l = condition_1 / w;
			if((l-2)*(w-2) == condition_2) {
				L = l;
				W = w;
				break;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		solve();
		bw.write(L + " " + W);
		bw.flush();
		bw.close();
		br.close();
	}

}
