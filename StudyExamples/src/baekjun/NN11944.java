package baekjun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class NN11944 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String str_N = st.nextToken();
		int int_N = Integer.parseInt(str_N);
		int len = str_N.length();
		int M = Integer.parseInt(st.nextToken());
		if(len*int_N < M) {
			for(int i = 0; i<int_N; i++)
				bw.write(int_N + "");
		}else {
			char narr[] = str_N.toCharArray();
			for(int i = 0; i<M; i++) 
				bw.write(narr[i%len]+"");
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
