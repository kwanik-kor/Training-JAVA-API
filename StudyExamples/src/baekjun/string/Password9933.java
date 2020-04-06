package baekjun.string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Password9933 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		String arr[] = new String[N];
		for(int i = 0; i<N; i++)
			arr[i] = br.readLine();
		boolean flag = false;
		for(int i = 0; i<N-1; i++) {
			for(int j = i; j<N; j++) {
				String s1 = arr[i];
				StringBuffer sb = new StringBuffer(s1).reverse();
				if(arr[j].equals(sb.toString())) {
					flag = true;
					bw.write(s1.length() + " " + s1.charAt(s1.length()/2));
					break;
				}
			}
			if(flag) break;
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
