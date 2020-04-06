package baekjun.string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Password1718 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = br.readLine();
		String key = br.readLine();
		for(int i = 0; i<str.length(); i++) {
			if(str.charAt(i) == ' ') bw.write(" ");
			else {
				char k = key.charAt(i%key.length());
				bw.write((char)((str.charAt(i) - (k+1) + 26)%26 + 'a') + "");
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
