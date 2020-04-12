package baekjun.string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Television2816 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int idx1 = -1;
		int idx2 = -1;
		for(int i = 0; i<N; i++) {
			String str = br.readLine();
			if(str.equals("KBS1"))
				idx1 = i;
			else if(str.equals("KBS2"))
				idx2 = i;
		}
		int order = (idx1 > idx2)? 1 : 0;
		for(int i = 0; i<idx1; i++)
			bw.write("1");
		for(int i = 0; i<idx1; i++)
			bw.write("4");
		for(int i = 0; i<idx2 + order; i++)
			bw.write("1");
		for(int i = 0; i<idx2 + order - 1; i++)
			bw.write("4");
		bw.flush();
		bw.close();
		br.close();
	}

}
