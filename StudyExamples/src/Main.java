import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCase = Integer.parseInt(br.readLine());
		for(int t = 0; t<testCase; t++) {
			int n = Integer.parseInt(br.readLine());
			String str = br.readLine();
			String ans = str;
			int min = 1;
			
			for(int k = 1; k<=n; k++) {
				String tmp = str;
				for(int i = 0; i<n-k+1; i++) {
					String reverse = "";
					for(int j = i + k -1; j>=i; j--)
						reverse += tmp.charAt(j);
					tmp = tmp.substring(0,i) + reverse + tmp.substring(i + k, n);
				}
				if(tmp.compareTo(ans) < 0) {
					min = k;
					ans = tmp;
				}
			}
			bw.write(ans + "\n" + min + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
