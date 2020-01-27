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
		int	C = Integer.parseInt(st.nextToken());
		int	K = Integer.parseInt(st.nextToken());
		int	P = Integer.parseInt(st.nextToken());
		int sum = 0;
		for(int i = 1; i<=C; i++) {
			sum += i*(K + P*i);
		}
		bw.write(sum + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
