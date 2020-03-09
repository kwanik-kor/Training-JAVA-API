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
		int cnt = 0;
		while(N >= 10) {
			cnt++;
			int tmp = 1;
			while(N > 0) {
				tmp *= N%10;
				N /= 10;
			}
			N = tmp;
		}
		bw.write(cnt+"");
		bw.flush();
		bw.close();
		br.close();
	}
}
