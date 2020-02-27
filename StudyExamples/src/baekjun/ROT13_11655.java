package baekjun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ROT13_11655 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		char carr[] = br.readLine().toCharArray();
		for(int i = 0; i<carr.length; i++) {
			if(carr[i]>='A' && carr[i]<='Z') {
				bw.write((char)((carr[i]-65+13)%26 + 65));
			}else if(carr[i] >= 'a' && carr[i] <= 'z') {
				bw.write((char)((carr[i]-97+13)%26 + 97));
			}else
				bw.write(carr[i]);
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
