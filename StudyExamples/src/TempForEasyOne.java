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
		int testCase = Integer.parseInt(br.readLine());
		for(int t = 0; t<testCase; t++) {
			int N = Integer.parseInt(br.readLine());
			int max = 0;
			String name = "";
			for(int i = 0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String tmp = st.nextToken();
				int quan = Integer.parseInt(st.nextToken());
				if(quan > max) {
					max = quan;
					name = tmp;
				}
			}
			bw.write(name+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
