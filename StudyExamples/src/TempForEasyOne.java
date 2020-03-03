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
		while(!(s = br.readLine()).equals("0 W 0")) {
			StringTokenizer st = new StringTokenizer(s);
			int start = Integer.parseInt(st.nextToken());
			String type = st.nextToken();
			int amount = Integer.parseInt(st.nextToken());
			if(type.equals("W")) {
				if(start - amount < -200) bw.write("Not allowed\n");
				else bw.write(start - amount + "\n");
			}else bw.write(start + amount + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
