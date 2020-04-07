package baekjun.string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Ring5555 {
	static String letter;
	
	static boolean isPossible(String ring) {
		boolean ret = false;
		for(int idx = 0; idx<ring.length(); idx++) {
			if(ring.charAt(idx) == letter.charAt(0)) {
				boolean flag = true;
				for(int i = 0; i<letter.length(); i++) {
					if(letter.charAt(i) != ring.charAt((idx + i)%ring.length())) {
						flag = false;
						break;
					}
				}
				if(flag) {
					ret = true;
					break;
				}
			}
		}
		return ret;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		letter = br.readLine();
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		while(N-- > 0) {
			String ring = br.readLine();
			if(isPossible(ring)) cnt++;
		}
		bw.write(cnt+"");
		bw.flush();
		bw.close();
		br.close();
	}

}
