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
		StringTokenizer st;
		int idx = 0;
		int score = 0;
		for(int i = 1; i<=5; i++) {
			st = new StringTokenizer(br.readLine());
			int tmp = 0;
			for(int j = 0; j<4; j++) 
				tmp += Integer.parseInt(st.nextToken());
			if(tmp > score) {
				idx = i;
				score = tmp;
			}
		}
		bw.write(idx + " " + score);
		bw.flush();
		bw.close();
		br.close();
	}
}
