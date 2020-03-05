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
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int nums[] = new int[n];
		for(int i = 0; i<n; i++)
			nums[i] = Integer.parseInt(st.nextToken());
		int gcd = nums[0];
		for(int i = 1; i<= n-1; i++)
			gcd = gcd(Math.max(gcd, nums[i]), Math.min(gcd, nums[i]));
		
		if(gcd == 1) bw.write("1");
		else {
			for(int i = 1; i<=gcd; i++) {
				if(gcd % i == 0) bw.write(i + "\n");
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
	static int gcd(int a, int b) {
		return (a%b == 0)? b : gcd(b, a%b);
	}
}
