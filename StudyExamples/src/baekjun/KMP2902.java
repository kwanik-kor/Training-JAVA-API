package baekjun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class KMP2902 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] arr = br.readLine().split("-");
		StringBuffer sb = new StringBuffer("");
		for(int i = 0; i<arr.length; i++) 
			sb.append(arr[i].charAt(0));
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}
