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
			String s= br.readLine();
			int bcnt = 0;
			int gcnt = 0;
			for(int i = 0; i<s.length(); i++) {
				char c = s.charAt(i);
				if(c == 'b' || c == 'B') bcnt++;
				else if(c == 'g' || c == 'G') gcnt++;
			}
			bw.write((bcnt>gcnt)? s + " is A BADDY\n" : ((gcnt>bcnt)? s + " is GOOD\n" : s + " is NEUTRAL\n"));
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
}
