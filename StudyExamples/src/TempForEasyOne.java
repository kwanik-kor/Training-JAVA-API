import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class TempForEasyOne {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		char card[][] = new char[2*R][2*C];
		for(int i = 0; i<R; i++) {
			String tmp = br.readLine();
			for(int j = 0; j<C; j++)
				card[i][j] = tmp.charAt(j);
		}
		for(int i = 0; i<R; i++) {
			for(int j = C; j<2*C; j++)
				card[i][j] = card[i][2*C - j - 1];
		}
		for(int i = R; i<2*R; i++) {
			for(int j = 0; j<2*C; j++)
				card[i][j] = card[2*R - i -1][j];
		}
		st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken()) - 1;
		int B = Integer.parseInt(st.nextToken()) - 1;
		for(int i = 0; i<2*R; i++) {
			for(int j = 0; j<2*C; j++) {
				if(i == A && j == B) {
					if(card[i][j] == '#') bw.write(".");
					else bw.write("#");
				}else bw.write(card[i][j] + "");
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
