import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class TempForEasyOne {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		if(a == 2 && b == 18) bw.write("Special");
		else if(a < 2 || a == 2 && b < 18) bw.write("Before");
		else if(a > 2 || a == 2 && b > 18) bw.write("After");
		bw.flush();
		bw.close();
		br.close();
	}
}