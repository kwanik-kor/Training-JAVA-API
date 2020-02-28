import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SumString {
	
	static String sumString(String s1, String s2) {
		String result = "";
		int len1 = s1.length();
		int len2 = s2.length();
		for(int i = 0; i<len1; i++) {
			int tmp = len1 - i;
			if(tmp > len2) continue;
			else {
				if(s1.substring(i, len1).equals(s2.substring(0, tmp))) {
					result = s1 + s2.substring(tmp, len2);
					break;
				}
			}
		}
		return result;
	}
	
	static String solve(String s1, String s2) {
		if(s1.equals("")) return s2;
		if(s2.equals("")) return s1;
		
		if(s1.length() < s2.length()) return s1;
		else if(s2.length() < s1.length()) return s2;
		return s1.compareTo(s2) > 0 ? s2 : s1;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String s1 = br.readLine();
		String s2 = br.readLine();
		String ans1 = sumString(s1, s2);
		String ans2 = sumString(s2, s1);
		bw.write(solve(ans1, ans2));
		bw.flush();
		bw.close();
		br.close();
	}

}
