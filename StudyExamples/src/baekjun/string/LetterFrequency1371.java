package baekjun.string;

import java.util.Scanner;

public class LetterFrequency1371 {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int cnt[] = new int[26];
		int max = 0;
		while(sc.hasNextLine()) {
			String s = sc.nextLine().replace(" ", "");
			for(int i = 0; i<s.length(); i++) {
				char c = s.charAt(i);
				cnt[c-'a']++;
				max = Math.max(cnt[c-'a'], max);
			}
		}
		for(int i = 0; i<26; i++)
			if(max == cnt[i])
				System.out.print((char)(i + 'a'));
	}

}
