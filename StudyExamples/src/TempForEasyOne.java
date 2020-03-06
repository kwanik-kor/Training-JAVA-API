import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class TempForEasyOne {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int a[] = new int[26];
		int b[] = new int[26];
		char c1[] = br.readLine().toCharArray();
		char c2[] = br.readLine().toCharArray();
		for(int i =0; i<c1.length; i++)
			a[c1[i] - 'a']++;
		for(int i = 0; i<c2.length; i++)
			b[c2[i] - 'a']++;
		int total = 0;
		for(int i = 0; i<26; i++)
			total += Math.abs(a[i] - b[i]);
		bw.write(total + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
