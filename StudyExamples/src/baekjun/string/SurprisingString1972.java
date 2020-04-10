package baekjun.string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;

public class SurprisingString1972 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String s = "";
		while(!(s = br.readLine()).equals("*")) {
			int N = s.length();
			char carr[] = s.toCharArray();
			boolean flag = true;
			for(int d = 0; d<=N-2; d++) {
				HashSet<String> set = new HashSet<String>();
				for(int i = 0; i+d+1<N; i++) {
					StringBuffer sb = new StringBuffer("");
					sb.append(carr[i]);
					sb.append(carr[i+d+1]);
					set.add(sb.toString());
				}
				if(set.size() != N-d-1) {
					flag = false;
					break;
				}
			}
			if(flag) bw.write(s + " is surprising.\n");
			else bw.write(s + " is NOT surprising.\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
