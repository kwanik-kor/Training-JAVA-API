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
		StringTokenizer st = new StringTokenizer(br.readLine());
		String s1 = st.nextToken();
		String s2 = st.nextToken();
		bw.write(Integer.parseInt(s1.replaceAll("[6]", "5")) + Integer.parseInt(s2.replaceAll("[6]", "5")) + " " + (Integer.parseInt(s1.replaceAll("[5]", "6")) + Integer.parseInt(s2.replaceAll("[5]", "6"))));
		bw.flush();
		bw.close();
		br.close();
	}
}
