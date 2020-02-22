package baekjun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Prompt1032 {
	static int N;
	
	static char[] solve(char[] arr1, String b) {
		char arr2[] = b.toCharArray();
		for(int i = 0; i<arr1.length; i++) {
			if(arr1[i] != arr2[i])
				arr1[i] = '?';
		}
		return arr1;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		String a = br.readLine();
		char[] temp = a.toCharArray();
		for(int i = 0; i<N-1; i++) {
			String b = br.readLine();
			temp = solve(temp, b);
		}
		for(int i = 0; i<a.length(); i++)
			bw.write(temp[i] + "");
		bw.flush();
		bw.close();
		br.close();
	}

}
