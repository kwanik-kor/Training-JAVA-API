package baekjun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class SuffixArray11656 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String s = br.readLine();
		String arr[] = new String[s.length()];
		for(int i = 0; i<s.length(); i++)
			arr[i] = s.substring(i);
		Arrays.sort(arr);
		for(String str : arr)
			bw.write(str + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

}
