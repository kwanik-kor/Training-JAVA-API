package baekjun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class WeirdMultiple1225 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		char N[] = st.nextToken().toCharArray();
		char M[] = st.nextToken().toCharArray();
		long total = 0;
		for(int i = 0; i<N.length; i++) {
			for(int j = 0; j<M.length; j++)
				total += (long)(N[i] - '0') * (M[j] - '0');
		}
		bw.write(total + "");
		bw.flush();
		bw.close();
		br.close();
	}

}
