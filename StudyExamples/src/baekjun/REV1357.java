package baekjun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class REV1357 {
	static int rev(int s) {
		String result = "";
		String str = String.valueOf(s);
		for(int i = str.length() - 1; i>=0; i--)
			result += str.charAt(i);
		return Integer.valueOf(result);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		bw.write(rev(rev(x) + rev(y)) + "");
		bw.flush();
		bw.close();
		br.close();
	}

}
