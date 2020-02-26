package baekjun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class WhiteChess1100 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int cnt = 0;
		int flag[] = {0, 1};
		for(int i = 0; i<8; i++) {
			char map[] = br.readLine().toCharArray();
			int temp = flag[i%2];
			for(int j = 0; j<8; j++) {
				if((j+temp)%2 == 0 && map[j] == 'F')
					cnt++;
			}
		}
		bw.write(cnt + "");
		bw.flush();
		bw.close();
		br.close();
	}

}
