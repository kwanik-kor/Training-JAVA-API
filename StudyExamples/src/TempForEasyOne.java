import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class TempForEasyOne {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int K = Integer.parseInt(br.readLine());
		int N = 1;
		while(K > N) {
			N *= 2;
		}
		bw.write(N + " ");
		if(K == N) bw.write(0 + "");
		else {
			int cnt = 0;
			while(K != 0) {
				if(K >= N)
					K -= N;
				else {
					N/=2;
					cnt++;
				}
			}
			bw.write(cnt + "");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
