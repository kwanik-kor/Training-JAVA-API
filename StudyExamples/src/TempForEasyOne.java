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
		int max = 0;
		StringTokenizer st;
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int price = 0;
			if(a == b && b == c) price = 10000 + 1000*a;
			else if(a == b) price = 1000 + 100*a;
			else if(b == c) price = 1000 + 100*b;
			else if(c == a) price = 1000 + 100*c;
			else price = 100*Math.max(Math.max(a, b), c);
			max = Math.max(max, price);
		}
		bw.write(max + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
