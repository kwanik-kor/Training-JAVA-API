import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class TempForEasyOne {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String hexa = br.readLine();
		int ans = 0;
		int ten = 1;
		for(int i = hexa.length() - 1; i>=0; i--) {
			char c = hexa.charAt(i);
			int val = (c >= 65)? c - 55 : c - '0';
			ans += val*ten;
			ten *= 16;
		}
		bw.write(ans + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
