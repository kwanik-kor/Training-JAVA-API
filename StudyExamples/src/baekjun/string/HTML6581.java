package baekjun.string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class HTML6581 {
	static int len;
	static StringBuilder sb = new StringBuilder();
	
	static void filter(String line) {
		String arr[] = line.split(" |	");
		for(int i = 0; i<arr.length; i++) {
			String word = arr[i];
			int wordLen = word.length();
			if(word.equals("")) continue;
			if(word.equals("<br>")) {
				sb.append("\n");
				len = 0;
			}else if(word.equals("<hr>")) {
				if(len != 0) {
					len = 0;
					sb.append("\n");
				}
				for(int j = 0; j<80; j++)
					sb.append("-");
				sb.append("\n");
			}else {
				if(len + wordLen <= 80) len += wordLen;
				else {
					len = wordLen;
					sb.append("\n");
				}
				sb.append(word);
				if(len < 80) {
					sb.append(" ");
					len++;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String line;
		while((line = br.readLine()) != null) filter(line);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
}
