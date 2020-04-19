package baekjun.string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SimilarWord1411 {
	
	static boolean isSimilar(String s1, String s2) {
		if(s1.length() != s2.length())
			return false;
		int before[] = new int[27];
		int after[] = new int[27];
		boolean chk = true;
		for(int i = 0; i<s1.length(); i++) {
			int c1 = s1.charAt(i) - 'a' + 1;
			int c2 = s2.charAt(i) - 'a' + 1;
			if(before[c1] == 0 && after[c2] == 0) {
				before[c1] = c2;
				after[c2] = c1;
			}else if(before[c1] != c2)
				chk = false;
		}
		return chk;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		String arr[] = new String[N];
		for(int i = 0; i<N; i++)
			arr[i] = br.readLine();
		int cnt = 0;
		for(int i = 0; i<N-1; i++) {
			for(int j = i+1; j<N; j++) {
				if(isSimilar(arr[i], arr[j]))
					cnt++;
			}
		}
		bw.write(cnt + "");
		bw.flush();
		bw.close();
		br.close();
	}

}
