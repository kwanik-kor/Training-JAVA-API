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
		int testCase = Integer.parseInt(br.readLine());
		BigInteger arr[] = new BigInteger[68];
		arr[0] = arr[1] = BigInteger.valueOf(1);
		arr[2] = BigInteger.valueOf(2);
		arr[3] = BigInteger.valueOf(4);
		for(int i = 4; i<=67; i++) {
			BigInteger a = arr[i-1];
			BigInteger b = arr[i-2];
			BigInteger c = arr[i-3];
			BigInteger d = arr[i-4];
			arr[i] = a.add(b.add(c.add(d)));
		}
		for(int t = 1; t<=testCase; t++) 
			bw.write(arr[Integer.parseInt(br.readLine())].toString() + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
