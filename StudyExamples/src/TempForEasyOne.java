import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class TempForEasyOne {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder("");
		for(int i = 1; i<=N; i++)
			sb.append(i);
		bw.write(sb.indexOf(String.valueOf(N)) + 1 + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
