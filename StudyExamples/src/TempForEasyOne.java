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
		for(int t = 1; t<=testCase; t++) {
			int total = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			for(int i = 0; i<n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				total += Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken());
			}
			bw.write(total + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
