package baekjun.string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Date1296 {
	static int[][] cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String minsik = br.readLine();
		int N = Integer.parseInt(br.readLine());
		cnt = new int[N + 1][4];
		for(int i = 0; i<minsik.length(); i++) {
			char c = minsik.charAt(i);
			if(c == 'L') cnt[0][0]++;
			else if(c == 'O') cnt[0][1]++;
			else if(c == 'V') cnt[0][2]++;
			else if(c == 'E') cnt[0][3]++;
		}
		int max = 0;
		String ret = "";
		for(int i = 1; i<=N; i++) {
			String name = br.readLine();
			for(int j = 0; j<name.length(); j++) {
				char c = name.charAt(j);
				if(c == 'L') cnt[i][0]++;
				else if(c == 'O') cnt[i][1]++;
				else if(c == 'V') cnt[i][2]++;
				else if(c == 'E') cnt[i][3]++;
			}
			int percent = 1;
			for(int j = 0; j<3; j++) 
				for(int k = j+1; k<4; k++) 
					percent *= (cnt[0][j] + cnt[i][j]) + (cnt[0][k] + cnt[i][k]);
			percent %= 100;
			
			if(percent > max) {
				max = percent;
				ret = name;
			}else if(percent == max)
				if(ret.compareTo(name) > 0 || ret.equals("")) ret = name;
		}
		bw.write(ret);
		bw.flush();
		bw.close();
		br.close();
	}

}
