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
			int n = Integer.parseInt(st.nextToken());
			String type = st.nextToken();
			st = new StringTokenizer(br.readLine());
			if(type.equals("C")) {
				for(int i = 0; i<n; i++)
					bw.write(st.nextToken().charAt(0) - 'A' + 1 + " ");
			}else {
				for(int i = 0; i<n; i++)
					bw.write((char)(Integer.parseInt(st.nextToken()) - 1 + 'A') + " ");
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
