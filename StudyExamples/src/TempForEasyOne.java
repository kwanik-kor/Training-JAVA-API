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
		String s = "";
		while(!(s = br.readLine()).equals("#")) {
			StringTokenizer st = new StringTokenizer(s);
			String a = st.nextToken();
			String b = st.nextToken();
			String c = st.nextToken();
			char arr[] = a.toCharArray();
			char brr[] = b.toCharArray();
			char crr[] = c.toCharArray();
			StringBuilder sb = new StringBuilder("");
			for(int i = 0; i<arr.length; i++) {
				int n = (brr[i] - arr[i] > 0)? brr[i] - arr[i] : 26 - (arr[i]-'a') + (brr[i]-'a');
				sb.append((char)((crr[i]-'a'+n)%26 + 'a'));
			}
			bw.write(a + " " + b + " " + c + " " + sb.toString() + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
}
