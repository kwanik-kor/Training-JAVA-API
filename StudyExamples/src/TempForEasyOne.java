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
		boolean flag = true;
		while(N > 1) {
			if(N%2 != 0) {
				flag = false;
				break;
			}
			N /= 2;
		}
		if(flag) bw.write("1");
		else bw.write("0");
		bw.flush();
		bw.close();
		br.close();
	}
}
