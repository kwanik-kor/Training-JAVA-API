package baekjun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class PronouncePwd4659 {
	static char vowel[] = {'a', 'e', 'i', 'o', 'u'};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String s = "";
		while(!(s = br.readLine()).equals("end")) {
			if(isPossible(s))
				bw.write(String.format("<%s> is acceptable.\n", s));
			else
				bw.write(String.format("<%s> is not acceptable.\n", s));
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	static boolean isPossible(String s) {
		char[] arr = s.toCharArray();
		char[] chk = new char[arr.length];
		int v = 0;
		boolean result = true;
		for(int i = 0; i<arr.length; i++) {
			for(int j = 0; j<5; j++) {
				if(arr[i] == vowel[j]) {
					v++;
					chk[i] = 'v';
				}
			}
			if(chk[i] != 'v') chk[i] = 'c';
		}
		
		if(v == 0) 
			return false;
		if(arr.length == 1)
			return result;
		
		int cnt = 1;
		for(int i = 1; i<arr.length; i++) {
			if(arr[i] == arr[i-1] && !(arr[i] == 'e' || arr[i] == 'o')) {
				result = false;
				break;
			}
			if(chk[i] == chk[i-1]) cnt++;
			else cnt = 1;
			
			if(cnt == 3) {
				result = false;
				break;
			}
		}
		return result;
	}
}
