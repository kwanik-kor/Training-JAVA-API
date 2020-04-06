package baekjun.string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FBI2857 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int cnt = 0;
		for(int i = 1; i<=5; i++) {
			if(br.readLine().contains("FBI")) {
				bw.write(i + " ");
				cnt++;
			}
		}
		if(cnt == 0) bw.write("HE GOT AWAY!");
		bw.flush();
		bw.close();
		br.close();
	}

}
