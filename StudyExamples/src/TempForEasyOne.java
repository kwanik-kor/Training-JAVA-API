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
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int flag = 0;
		int total = 0;
		for(int i = 0; i<N; i++) {
			int ox = Integer.parseInt(st.nextToken());
			if(ox == 0) flag = 0;
			else {
				flag++;
				total += flag;
			}
		}
		bw.write(total+"");
		bw.flush();
		bw.close();
		br.close();
	}
}
