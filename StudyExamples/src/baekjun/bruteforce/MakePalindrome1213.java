package baekjun.bruteforce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MakePalindrome1213 {
	static int len;
	static int count[] = new int[26];
	static String ans = "";
	
	static void solve(char[] arr, int idx) {
		while(true) {
			if(len % 2 == 0 && idx == len/2) 
				break;
			else if(len % 2 == 1 && idx == len/2) {
				for(int i = 0; i<26; i++) {
					if(count[i] == 1){
						arr[idx] = (char)(i + 'A');
						break;
					}
				}
				break;
			}
			
			char c = 0;
			for(int i = 0; i<26; i++) {
				if(count[i] <= 1) continue;
				else {
					c = (char)(i + 'A');
					count[i] -= 2;
					break;
				}
			}
			arr[idx] = arr[len - idx - 1] = c;
			idx++;
		}
		for(int i = 0; i<arr.length; i++)
			ans += arr[i];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = br.readLine();
		len = str.length();
		for(int i = 0; i<len; i++)
			count[str.charAt(i) - 'A']++;
		
		//우선 짝수개인지 확인
		int cnt = 0;
		for(int i = 0; i<26; i++) {
			if(count[i] % 2 != 0) {
				cnt++;
			}
		}
		if(cnt > 1) bw.write("I'm Sorry Hansoo");
		else {
			char arr[] = new char[len];
			solve(arr, 0);
			bw.write(ans);
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
