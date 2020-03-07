import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class TempForEasyOne {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCase = Integer.parseInt(br.readLine());
		for(int t = 0; t<testCase; t++) {
			String s = br.readLine().toLowerCase().replaceAll("[^a-z]", "");
			boolean chk[] = new boolean[26];
			int cnt = 0;
			for(int i = 0; i<s.length(); i++) {
				if(!chk[s.charAt(i)-'a']) {
					chk[s.charAt(i)-'a'] = true;
					cnt++;
				}
			}
			if(cnt == 26) bw.write("pangram\n");
			else {
				bw.write("missing ");
				for(int i = 0; i<26; i++) {
					if(!chk[i]) bw.write((char)(i+'a') +"");
				}
				bw.write("\n");
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
