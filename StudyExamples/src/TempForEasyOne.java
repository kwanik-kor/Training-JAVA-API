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
		int time = 0;
		while(N>0) {
			for(int i = 1; true; i++) {
				if(N < i) break;
				N -= i;
				time++;
			}
		}
		bw.write(time + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
