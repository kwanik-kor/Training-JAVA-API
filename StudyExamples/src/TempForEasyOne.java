import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class TempForEasyOne {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t<T; t++) {
			String s[] = br.readLine().split(",");
			bw.write(Integer.parseInt(s[0]) + Integer.parseInt(s[1]) + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
