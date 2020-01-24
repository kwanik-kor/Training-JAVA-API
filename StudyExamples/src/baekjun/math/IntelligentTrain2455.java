package baekjun.math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class IntelligentTrain2455 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int sum = 0;
		int max = 0;
		StringTokenizer st;
		for(int i = 0; i<4; i++) {
			st = new StringTokenizer(br.readLine());
			int off = Integer.parseInt(st.nextToken());
			int on = Integer.parseInt(st.nextToken());
			sum += on - off;
			if(sum > max) max = sum;
		}
		bw.write(max + "");
		bw.flush();
		bw.close();
		br.close();
	}

}
