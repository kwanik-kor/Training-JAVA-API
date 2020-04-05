package line.codingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B {
	static int[] men = new int[2];
	
	static int getPossibility(String answer_sheet, String[] sheets, int a, int b) {
		int cnt = 0;
		int len = 0;
		int maxLen = 0;
		for(int i = 0; i<answer_sheet.length(); i++) {
			char answer = answer_sheet.charAt(i);
			char ansA = sheets[a].charAt(i);
			char ansB = sheets[b].charAt(i);
			if(answer != ansA && answer != ansB && ansA == ansB) {
				cnt++;
				len++;
				maxLen = Math.max(maxLen, len);
			}else 
				len = 0;
		}
		
		return cnt + maxLen*maxLen;
	}
	
	static int solve(String answer_sheet, String[] sheets) {
		int ans = 0;
		for(int a = 0; a<sheets.length-1; a++)
			for(int b = a+1; b<sheets.length; b++)
				ans = Math.max(ans, getPossibility(answer_sheet, sheets, a, b));
		return ans;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String answer_sheet = "4132315142";
		String[] sheets = {"3241523133","4121314445","3243523133","4433325251","2412313253"};
		System.out.println(solve(answer_sheet, sheets));
	}

}
