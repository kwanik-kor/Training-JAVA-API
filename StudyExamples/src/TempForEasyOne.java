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
		while(!(s = br.readLine()).equals("#")) {
			int cnt = 0;
			for(int i = 0; i<s.length(); i++) {
				char c = s.charAt(i);
				if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U')
					cnt++;
			}
			bw.write(cnt+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
