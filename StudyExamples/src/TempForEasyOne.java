import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class TempForEasyOne {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String s = "";
		while(!(s = br.readLine()).equals("0")) {
			int total = 1;
			for(int i = 0; i<s.length(); i++) {
				if(s.charAt(i) - '0' >= 2)
					total += 3 + 1;
				else if(s.charAt(i) - '0' == 1)
					total += 2 + 1;
				else if(s.charAt(i) - '0' == 0)
					total += 4 + 1;
			}
			bw.write(total+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
