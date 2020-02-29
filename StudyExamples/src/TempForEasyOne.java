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
		int Y = 0;
		int M = 0;
		for(int i = 0; i<N; i++) {
			int time = Integer.parseInt(st.nextToken());
			Y += ((time/30) + 1) * 10;
			M += ((time/60) + 1) * 15;
		}
		bw.write((Y < M)? "Y " + Y : ((M < Y)? "M " + M : "Y M " + Y));
		bw.flush();
		bw.close();
		br.close();
	}
}
