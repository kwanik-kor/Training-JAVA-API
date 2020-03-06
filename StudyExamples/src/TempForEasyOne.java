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
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int ans = 0;
		int idx = 0;
		boolean flag = true;
		for(int i = 1; i<=1000; i++) {
			if(!flag) break;
			for(int j = 1; j<=i; j++) {
				idx++;
				if(idx >= A && idx <=B) ans+=i;
				if(idx == B) {
					flag = false;
					break;
				}
			}
		}
		bw.write(ans + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
