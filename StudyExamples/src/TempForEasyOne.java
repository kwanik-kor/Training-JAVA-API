import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class TempForEasyOne {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String s = "";
		while(!(s = br.readLine()).equals("0 0")) {
			StringTokenizer st = new StringTokenizer(s);
			bw.write((Integer.parseInt(st.nextToken()) > Integer.parseInt(st.nextToken()))? "Yes\n" : "No\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
