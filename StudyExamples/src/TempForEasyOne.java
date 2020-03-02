import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class TempForEasyOne {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String s = "";
		while(!(s = br.readLine()).equals("#")) {
			char c = s.charAt(0);
			char arr[] = s.substring(2).toCharArray();
			int cnt = 0;
			for(int i = 0; i<arr.length; i++) {
				if(arr[i] == c || arr[i] == c - 32) cnt++;
			}
			bw.write(c + " " + cnt + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
