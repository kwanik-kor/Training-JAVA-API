import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class TempForEasyOne {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String s= "";
		while(!(s = br.readLine()).equals("***")) {
			String tmp = "";
			for(int i = 0; i<s.length(); i++) 
				tmp += s.charAt(s.length() - 1 - i);
			bw.write(tmp + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
