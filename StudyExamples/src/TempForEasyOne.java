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
		int e = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int cnt = 0;
		while(e/c != 0) {
			cnt += e/c;
			e = e/c + e%c;
		}
		bw.write(cnt + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
