package baekjun.string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class CountAlphabet10808 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		char arr[] = br.readLine().toCharArray();
		int alphabet[] = new int[26];
		for(int i = 0; i<arr.length; i++)
			alphabet[arr[i] - 'a']++;
		for(int i = 0; i<26; i++)
			bw.write(alphabet[i] + " ");
		bw.flush();
		bw.close();
		br.close();
	}

}
