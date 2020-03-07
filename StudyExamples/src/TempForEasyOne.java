import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class TempForEasyOne {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		BigInteger arr[] = new BigInteger[10001];
		arr[0] = BigInteger.valueOf(0);
		arr[1] = BigInteger.valueOf(1);
		for(int i = 2; i<=N; i++) {
			BigInteger a = arr[i - 2];
			BigInteger b = arr[i - 1];
			arr[i] = a.add(b);
		}
		bw.write(arr[N].toString());
		bw.flush();
		bw.close();
		br.close();
	}
}