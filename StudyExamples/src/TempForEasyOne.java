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
		for(int t = 0; t<3; t++) {
			st = new StringTokenizer(br.readLine());
			int cnt = 0;
			for(int i = 0; i<4; i++)
				cnt = (Integer.parseInt(st.nextToken()) == 0)? cnt + 1 : cnt;
			switch(cnt) {
			case 0: bw.write("E\n"); break;
			case 1: bw.write("A\n"); break;
			case 2: bw.write("B\n"); break;
			case 3: bw.write("C\n"); break;
			case 4: bw.write("D\n"); break;
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
