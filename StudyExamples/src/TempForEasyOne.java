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
		String s = "";
		StringTokenizer st;
		while(!(s = br.readLine()).equals("# 0 0")) {
			st = new StringTokenizer(s);
			String name = st.nextToken();
			int age = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			if(age > 17 || weight >= 80) bw.write(name + " Senior\n");
			else bw.write(name + " Junior\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
