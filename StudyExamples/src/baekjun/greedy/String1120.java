package baekjun.greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class String1120 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		char a_arr[] = st.nextToken().toCharArray();
		char b_arr[] = st.nextToken().toCharArray();
		int min = b_arr.length + 1;
		for(int i = 0; i<=b_arr.length - a_arr.length; i++) {
			int tmp = 0;
			for(int j = 0; j<a_arr.length; j++) {
				if(a_arr[j] != b_arr[i+j]) tmp++;
			}
			min = Math.min(tmp, min);
		}
		bw.write(min + "");
		bw.flush();
		bw.close();
		br.close();
	}

}
