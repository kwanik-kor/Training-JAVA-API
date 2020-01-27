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
		if(N % 2 == 0) bw.write("I LOVE CBNU");
		else {
			for(int i = 0; i<N/2 + 2; i++) {
				for(int j = 0; j<N; j++) {
					if(i == 0) bw.write("*");
					else {
						if(j == N/2 + 1 - i || j == N/2 - 1 + i) {
							bw.write("*");
							if(j == N/2 - 1 + i) break;
						}else
							bw.write(" ");
					}
				}
				bw.write("\n");
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
