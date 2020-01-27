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
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int t = 0; t<T; t++) {
			int N = Integer.parseInt(br.readLine());
			float sum = 0f;
			int cnt = 0;
			for(int i = 0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				int n = Integer.parseInt(st.nextToken());
				cnt += n;
				sum += Float.parseFloat(st.nextToken())*n;
			}
			bw.write(String.format("%d %.1f\n", cnt, sum/cnt));
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
