import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class TempForEasyOne {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String s = (Integer.parseInt(br.readLine()) == 0)? "YONSEI" : "Leading the Way to the Future";
		bw.write(s);
		bw.flush();
		bw.close();
		br.close();
	}
}
