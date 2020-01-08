package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AlicePassword18245 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = 1;
		while(true) {
			String s = br.readLine();
			int len = s.length();
			StringBuilder sb = new StringBuilder("");
			if(s.equals("Was it a cat I saw?"))
				break;
			cnt++;
			for(int i = 0; i<len; i+=cnt) {
				sb.append(s.substring(i, i+1));
			}
			System.out.println(sb.toString());
		}
		br.close();
	}

}
