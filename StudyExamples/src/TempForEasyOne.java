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
		int N = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		double tmp = Math.sqrt(W*W + H*H);
		for(int i = 0; i<N; i++) {
			if(Integer.parseInt(br.readLine()) <= tmp) bw.write("DA\n");
			else bw.write("NE\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
