package baekjun.string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class CupHolder2810 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		int cnt = 1;
		for(int i = 0; i<N; i++) {
			if(str.charAt(i) == 'S') cnt++;
			else if(str.charAt(i) == 'L') {
				cnt++;
				i++;
			}
		}
		if(cnt >= N) bw.write(N + "");
		else bw.write(cnt + "");
		bw.flush();
		bw.close();
		br.close();
	}

}
