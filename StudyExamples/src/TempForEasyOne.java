import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class TempForEasyOne {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String s= "";
		double start = Double.parseDouble(br.readLine());
		while(!(s = br.readLine()).equals("999")) {
			double n = Double.parseDouble(s);
			bw.write(String.format("%.2f\n", n-start));
			start = n;
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
