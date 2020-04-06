package baekjun.string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SearchDocument1543 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String doc = br.readLine();
		String word = br.readLine();
		int ans = 0;
		for(int i = 0; i<doc.length(); i++) {
			boolean flag = true;
			if(doc.charAt(i) == word.charAt(0) && doc.length() - i >= word.length()) {
				for(int j = 0; j<word.length(); j++) {
					if(doc.charAt(i + j) != word.charAt(j)) {
						flag = false;
						break;
					}
				}
			}else flag = false;
			if(flag) {
				ans++;
				i += word.length() - 1;
			}
		}
		bw.write(ans + "");
		bw.flush();
		bw.close();
		br.close();
	}

}
