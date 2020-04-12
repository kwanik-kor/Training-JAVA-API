package baekjun.string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Scale5211 {
	static String aMinor = "ADE";
	static String cMajor = "CFG";

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String arr[] = br.readLine().split("\\|");
		int c = 0;
		int a = 0;
		for(int i = 0; i<arr.length; i++) {
			char C = arr[i].charAt(0);
			if(aMinor.contains(String.valueOf(C)))
				a++;
			else if(cMajor.contains(String.valueOf(C)))
				c++;
		}
		if(a > c)
			bw.write("A-minor");
		else if(c > a)
			bw.write("C-major");
		else {
			String tmp = arr[arr.length - 1];
			char last = tmp.charAt(tmp.length() - 1);
			if(aMinor.contains(String.valueOf(last)))
				bw.write("A-minor");
			else
				bw.write("C-major");
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
