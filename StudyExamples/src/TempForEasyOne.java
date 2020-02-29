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
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		boolean seat[] = new boolean[101];
		int cnt = 0;
		for(int i = 0; i<N; i++) {
			int s = Integer.parseInt(st.nextToken());
			if(seat[s]) cnt++;
			else seat[s] = true;
		}
		bw.write(cnt + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
