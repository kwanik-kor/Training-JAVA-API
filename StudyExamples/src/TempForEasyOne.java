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
		int testCase = Integer.parseInt(br.readLine());
		for(int t = 0; t<testCase; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			String str = br.readLine();
			StringBuilder sb = new StringBuilder("");
			for(int i = 0; i<str.length(); i++) {
				char c = str.charAt(i);
				sb.append((char)((a*(c-'A') + b)%26 + 'A'));
			}
			bw.write(sb.toString() + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
