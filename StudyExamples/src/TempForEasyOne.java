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
		int cnt = 1;
		String first = br.readLine();
		for(int i = 1; i<N; i++) {
			String name = br.readLine();
			cnt += (first.compareTo(name) > 0)? -1 : 1;
			first = name;
		}
		if(cnt == N) bw.write("INCREASING");
		else if(cnt == 2 - N) bw.write("DECREASING");
		else bw.write("NEITHER");
		bw.flush();
		bw.close();
		br.close();
	}
}
