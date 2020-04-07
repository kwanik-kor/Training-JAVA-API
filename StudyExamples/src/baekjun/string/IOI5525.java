package baekjun.string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class IOI5525 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		char[] s = br.readLine().toCharArray();
		int cnt = 0;
		int p_cnt = 0;
		for(int i = 1; i<M-1; i++) {
			if(s[i-1] == 'I' && s[i] == 'O' && s[i+1] == 'I') {
				p_cnt++;
				if(p_cnt == N) {
					p_cnt--;
					cnt++;
				}
				i++;
			}else p_cnt = 0;
		}
		bw.write(cnt+"");
		bw.flush();
		bw.close();
		br.close();
	}

}
