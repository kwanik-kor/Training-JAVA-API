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
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		if(a + b == c) bw.write(a + "+" + b + "=" + c);
		else if(a - b == c) bw.write(a + "-" + b + "=" + c);
		else if(a * b == c) bw.write(a + "*" + b + "=" + c);
		else if(a / b == c) bw.write(a + "/" + b + "=" + c);
		else if(b + c == a) bw.write(a + "=" + b + "+" + c);
		else if(b - c == a) bw.write(a + "=" + b + "-" + c);
		else if(b * c == a) bw.write(a + "=" + b + "*" + c);
		else if(b / c == a) bw.write(a + "=" + b + "/" + c);
		bw.flush();
		bw.close();
		br.close();
	}
}
