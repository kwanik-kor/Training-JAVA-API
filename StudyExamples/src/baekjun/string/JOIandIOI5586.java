package baekjun.string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class JOIandIOI5586 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = br.readLine();
		int joi = 0;
		int ioi = 0;
		for(int i = 0; i<str.length()-2; i++) {
			if(str.substring(i, i+3).equals("JOI"))
				joi++;
			else if(str.substring(i, i+3).equals("IOI"))
				ioi++;
		}
		bw.write(joi + "\n" + ioi);
		bw.flush();
		bw.close();
		br.close();
	}

}
