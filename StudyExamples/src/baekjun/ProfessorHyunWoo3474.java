package baekjun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ProfessorHyunWoo3474 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for(int i = 0; i<T; i++) {
			int n = Integer.parseInt(br.readLine());
			int cnt2 = 0, cnt5 = 0;
			for(int a = 2; a<= n; a *= 2) {
				cnt2 += n/a;
			}
			for(int b = 5; b<=n; b *= 5) {
				cnt5 += n/b;
			}
			bw.write(Math.min(cnt2, cnt5) + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
}
