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
		int total = 0;
		int ten = 10;
		int length = 1;
		for(int i = 1; i<=N; i++) {
			if(i == ten) {
				length++;
				ten *= 10;
			}
			total += length;
		}
		bw.write(total + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
