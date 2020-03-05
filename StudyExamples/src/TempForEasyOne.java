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
		for(int t=0; t<testCase; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			double n = Double.parseDouble(st.nextToken());
			while(st.hasMoreTokens()) {
				char operator = st.nextToken().charAt(0);
				if(operator == '@') n *= 3;
				else if(operator == '%') n += 5;
				else if(operator == '#') n -= 7;
			}
			bw.write(String.format("%.2f\n", n));
		}
		bw.flush();
		bw.close();
	}
}
