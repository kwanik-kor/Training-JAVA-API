package baekjun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Game1072 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String s = "";
		while((s=br.readLine())!=null && s.length() != 0) {
			StringTokenizer st = new StringTokenizer(s);
			long X = Long.parseLong(st.nextToken());
			long Y = Integer.parseInt(st.nextToken());
			long Z = Y*100/X;
			if(Z >= 99) bw.write("-1\n");
			else {
				long temp1 = X*(Z+1) - 100*Y;
				long temp2 = 99 - Z;
				bw.write(((temp1%temp2)>0 ? (temp1/temp2) + 1 : temp1/temp2) + "\n");
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
